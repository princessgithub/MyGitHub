package com.westone.ucss.test;

import com.westone.pboc.service.HSMApiService;
import com.westone.pboc.service.imp.HSMApiServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * CSMP接口测试类，算法选择为DES
 * 
 * @since 2014.12.5
 * @author shiling
 * 
 */
public class TestGenMAC extends TestCase {

	private HSMApiService csmpApi;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		csmpApi = new HSMApiServiceImpl();
	}

	// 6.计算MAC
	@Test
	public void testHSM_GenMAC1() {
		String algFlag = "2";
		String macFlag = "3";
		String nodeApp = "001";
		String nodeID = "0101";
		String keyType = "4";
		String iv = "00000000000000000000000000000000";
		String macdatalen = "54";
		String macdata = "303830302031313237313834303336203030303038322031343030303030303030303030303030203130312030383033353730303030";

		String mac = "";

		try {
			List<String> result = csmpApi.HSM_GenMAC(nodeApp, nodeID, algFlag, macFlag, keyType, iv, macdatalen, macdata);
			for (String obj : result) {
				mac = obj;
				System.out.println("计算MAC结果：\n" + mac);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			List<String> result = csmpApi.HSM_VerifyMAC(nodeApp, nodeID, algFlag, macFlag, keyType, iv, macdatalen, macdata, mac);
			for (String s : result) {
				System.out.println("验证MAC结果：\n" + s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
