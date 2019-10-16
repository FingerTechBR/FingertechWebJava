package com.FingerTechWeb.FingertechAPIWeb.Utils;

import java.util.ArrayList;

import com.FingerTechWeb.FingertechAPIWeb.Models.Digital;
import com.nitgen.SDK.BSP.NBioBSPJNI;
import com.nitgen.SDK.BSP.NBioBSPJNI.FIR_HANDLE;

import ft_enro.view.Enroll;


public class UtilsNitgen {
	NBioBSPJNI bsp;
	NBioBSPJNI.IndexSearch    IndexSearchEngine;
	ArrayList<Digital> ad;	
	
	public  UtilsNitgen(){
		
		NBioBSPJNI bsp;
		 bsp = new NBioBSPJNI();
	     IndexSearchEngine = bsp.new IndexSearch();		 
		 this.bsp = bsp;
		
		
		
	}
	
	
	public String Captura() {
		
		bsp.OpenDevice();		
		NBioBSPJNI.FIR_HANDLE captura = bsp.new FIR_HANDLE();	
		bsp.Capture(captura);	
		bsp.CloseDevice();
		return  handleparaString(captura);
		
	}
	
	public boolean idenficacao(String digital) {
		
		bsp.OpenDevice();
		Boolean resultado = new Boolean(false);
		
		bsp.Verify(stringToInputFIR(digital), resultado, null);
		
		return resultado;
		
	}

	
	public String enrollDigital() {
		
		Enroll enroll = new Enroll();
		enroll.EnrolInit();
		
		return "ok";
		
		
		
		
	}
	
// 	não necessário
//	//Verifica digital com 1 para N
//	public HashMap check1toN(ArrayList<Digital> ad, Digital d){		
//		
//		NBioBSPJNI.IndexSearch.SAMPLE_INFO sampleInfo = IndexSearchEngine.new SAMPLE_INFO();
//		NBioBSPJNI.IndexSearch.FP_INFO fpInfo = IndexSearchEngine.new FP_INFO();
//		HashMap<Object, Object> map = new HashMap<>();	
//			
//		ad.forEach(t -> {	
//			IndexSearchEngine.AddFIR(stringToInputFIR(t.getDigitalp()), t.getId(), sampleInfo);			
//		});		
//		
//		IndexSearchEngine.Identify(stringToInputFIR(d.getPrimeiradigital()), 5, fpInfo, 5);		
//		if (CheckError())  {
//            if (bsp.GetErrorCode() == NBioBSPJNI.ERROR.NBioAPIERROR_INDEXSEARCH_IDENTIFY_FAIL)  {
//              map.put("error", "Usuário não idêntificado");
//              //System.err.println("usuario não encontrado");
//              return map;              
//            }
//            else if (bsp.GetErrorCode() == NBioBSPJNI.ERROR.NBioAPIERROR_INDEXSEARCH_IDENTIFY_STOP)  {
//            	map.put("error", "tempo limite ultrapassdo");  
//            	 return map;
//            }        
//		}		
//		d.setId(fpInfo.ID);		
//		//map.put("Digital", d);
//		map.put("Sucesso", d.getId());
//		map.put("Usuario", d);
//		//System.err.println("User ID "+d.getId());     
//		
//		return map;	
//		
//	}
//		

	
	
	//convert String para inputFir
	//retorta INPUT_FIR
	public NBioBSPJNI.INPUT_FIR stringToInputFIR(String digital) {
		
		NBioBSPJNI.FIR_TEXTENCODE textSavedFIRA;
		textSavedFIRA = bsp.new FIR_TEXTENCODE();
		textSavedFIRA.TextFIR = digital;
		NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
		inputFIR.SetTextFIR(textSavedFIRA);			
		return inputFIR;
		
	}
	
	
	//Handle para String
	public String handleparaString(NBioBSPJNI.FIR_HANDLE digital) {
		
		NBioBSPJNI.FIR_TEXTENCODE textSavedFIRA = bsp.new FIR_TEXTENCODE();		
		bsp.GetTextFIRFromHandle(digital, textSavedFIRA);	
		
		
		return textSavedFIRA.TextFIR;
		
		
		
	}
	
	
	public boolean check1to1(Digital fp, Digital fp2){		

		NBioBSPJNI.FIR_TEXTENCODE textSavedFIRA;
		NBioBSPJNI.FIR_TEXTENCODE textSavedFIRA2;
		
        textSavedFIRA = bsp.new FIR_TEXTENCODE();
        textSavedFIRA.TextFIR = fp.getDigitalp(); 
        
        textSavedFIRA2 = bsp.new FIR_TEXTENCODE();
        textSavedFIRA2.TextFIR = fp2.getDigitals();	
        
		NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
		NBioBSPJNI.INPUT_FIR inputFIR2 = bsp.new INPUT_FIR();
		Boolean bResult = new Boolean(false);
		NBioBSPJNI.FIR_PAYLOAD payload = bsp.new FIR_PAYLOAD();
		
		inputFIR.SetTextFIR(textSavedFIRA);
		inputFIR2. SetTextFIR(textSavedFIRA2);		
		
		bsp.VerifyMatch(inputFIR, inputFIR2, bResult, payload);
		
		
		return bResult;
		
	}
	
	
	//convert não implantada ainda fix me
	public com.nitgen.SDK.BSP.NBioBSPJNI.INPUT_FIR INPUT_FIR (String fp1, String fp2) {
		
		NBioBSPJNI.INPUT_FIR ip;
		ip =  bsp.new INPUT_FIR();		
		
		return ip;
		
	}
	
	
	   private Boolean CheckError()    {
	        if (bsp.IsErrorOccured())  {	           
	            return true;
	        }

	        return false;
	    }
}
