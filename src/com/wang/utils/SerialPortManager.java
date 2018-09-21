package com.wang.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TooManyListenersException;




import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

/**
 * 涓插彛绠＄悊
 * 
 * @author yangle
 */
@SuppressWarnings("all")
public class SerialPortManager {

	/**
	 * 鏌ユ壘鎵�湁鍙敤绔彛
	 * 
	 * @return 鍙敤绔彛鍚嶇О鍒楄〃
	 */
	public static final ArrayList<String> findPorts() {
		// 鑾峰緱褰撳墠鎵�湁鍙敤涓插彛
		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
		ArrayList<String> portNameList = new ArrayList<String>();
		// 灏嗗彲鐢ㄤ覆鍙ｅ悕娣诲姞鍒癓ist骞惰繑鍥炶List
		while (portList.hasMoreElements()) {
			String portName = portList.nextElement().getName();
			portNameList.add(portName);
		}
		return portNameList;
	}

	/**
	 * 鎵撳紑涓插彛
	 * 
	 * @param portName
	 *            绔彛鍚嶇О
	 * @param baudrate
	 *            娉㈢壒鐜�	 * @return 涓插彛瀵硅薄
	 * @throws PortInUseException
	 *             涓插彛宸茶鍗犵敤
	 */
	public static final SerialPort openPort(String portName, int baudrate) throws PortInUseException {
		try {
			// 閫氳繃绔彛鍚嶈瘑鍒鍙�			
			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			// 鎵撳紑绔彛锛屽苟缁欑鍙ｅ悕瀛楀拰涓�釜timeout锛堟墦寮�搷浣滅殑瓒呮椂鏃堕棿锛�			
			CommPort commPort = portIdentifier.open(portName, 2000);
			// 鍒ゆ柇鏄笉鏄覆鍙�			
			if (commPort instanceof SerialPort) {
				SerialPort serialPort = (SerialPort) commPort;
				try {
					// 璁剧疆涓�笅涓插彛鐨勬尝鐗圭巼绛夊弬鏁�					// 鏁版嵁浣嶏細8
					// 鍋滄浣嶏細1
					// 鏍￠獙浣嶏細None
					serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
							SerialPort.PARITY_NONE);
				} catch (UnsupportedCommOperationException e) {
					e.printStackTrace();
				}
				return serialPort;
			}
		} catch (NoSuchPortException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	/**
	 * 鍏抽棴涓插彛
	 * 
	 * @param serialport
	 *            寰呭叧闂殑涓插彛瀵硅薄
	 */
	public static void closePort(SerialPort serialPort) {
		if (serialPort != null) {
			serialPort.close();
		}
	}

	/**
	 * 寰�覆鍙ｅ彂閫佹暟鎹�	 * 
	 * @param serialPort
	 *            涓插彛瀵硅薄
	 * @param order
	 *            寰呭彂閫佹暟鎹�	 */
	public static void sendToPort(SerialPort serialPort, byte[] order) {
		OutputStream out = null;
		try {
			out = serialPort.getOutputStream();
			out.write(order);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
					out = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 浠庝覆鍙ｈ鍙栨暟鎹�	 * 
	 * @param serialPort
	 *            褰撳墠宸插缓绔嬭繛鎺ョ殑SerialPort瀵硅薄
	 * @return 璇诲彇鍒扮殑鏁版嵁
	 */
	public static byte[] readFromPort(SerialPort serialPort) {
		InputStream in = null;
		byte[] bytes = {};
		try {
			in = serialPort.getInputStream();
			// 缂撳啿鍖哄ぇ灏忎负涓�釜瀛楄妭
			byte[] readBuffer = new byte[1];
			int bytesNum = in.read(readBuffer);
			while (bytesNum > 0) {
				bytes = ArrayUtils.concat(bytes, readBuffer);
				bytesNum = in.read(readBuffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bytes;
	}

	/**
	 * 娣诲姞鐩戝惉鍣�	 * 
	 * @param port
	 *            涓插彛瀵硅薄
	 * @param listener
	 *            涓插彛瀛樺湪鏈夋晥鏁版嵁鐩戝惉
	 */
	public static void addListener(SerialPort serialPort, DataAvailableListener listener) {
		try {
			// 缁欎覆鍙ｆ坊鍔犵洃鍚櫒
			serialPort.addEventListener(new SerialPortListener(listener));
			// 璁剧疆褰撴湁鏁版嵁鍒拌揪鏃跺敜閱掔洃鍚帴鏀剁嚎绋�			
			serialPort.notifyOnDataAvailable(true);
			// 璁剧疆褰撻�淇′腑鏂椂鍞ら啋涓柇绾跨▼
			serialPort.notifyOnBreakInterrupt(true);
		} catch (TooManyListenersException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 涓插彛鐩戝惉
	 */
	public static class SerialPortListener implements SerialPortEventListener {

		private DataAvailableListener mDataAvailableListener;

		public SerialPortListener(DataAvailableListener mDataAvailableListener) {
			this.mDataAvailableListener = mDataAvailableListener;
		}

		public void serialEvent(SerialPortEvent serialPortEvent) {
			switch (serialPortEvent.getEventType()) {
			case SerialPortEvent.DATA_AVAILABLE: // 1.涓插彛瀛樺湪鏈夋晥鏁版嵁
				if (mDataAvailableListener != null) {
					mDataAvailableListener.dataAvailable();
				}
				break;

			case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2.杈撳嚭缂撳啿鍖哄凡娓呯┖
				break;

			case SerialPortEvent.CTS: // 3.娓呴櫎寰呭彂閫佹暟鎹�				
				break;

			case SerialPortEvent.DSR: // 4.寰呭彂閫佹暟鎹噯澶囧ソ浜�				
				break;

			case SerialPortEvent.RI: // 5.鎸搩鎸囩ず
				break;

			case SerialPortEvent.CD: // 6.杞芥尝妫�祴
				break;

			case SerialPortEvent.OE: // 7.婧綅锛堟孩鍑猴級閿欒
				break;

			case SerialPortEvent.PE: // 8.濂囧伓鏍￠獙閿欒
				break;

			case SerialPortEvent.FE: // 9.甯ч敊璇�				
				break;

			case SerialPortEvent.BI: // 10.閫氳涓柇
				System.out.println("閫氳涓柇");
				break;

			default:
				break;
			}
		}
	}

	/**
	 * 涓插彛瀛樺湪鏈夋晥鏁版嵁鐩戝惉
	 */
	public interface DataAvailableListener {
		/**
		 * 涓插彛瀛樺湪鏈夋晥鏁版嵁
		 */
		void dataAvailable();
	}
}
