package com.FingerTechWeb.FingertechAPIWeb.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FingerTechWeb.FingertechAPIWeb.Utils.UtilsNitgen;
import com.nitgen.SDK.BSP.NBioBSPJNI;

@RestController
@RequestMapping("/api/public/v1")
public class CaptureController {
	NBioBSPJNI bsp;
	UtilsNitgen ut = new UtilsNitgen();
	
	
	
	@CrossOrigin
	@RequestMapping(value= "/captura/Capturar/1", method = RequestMethod.GET)
	public String captureSingleFinger() {
		
		String retorno = ut.Captura();		
		return retorno;	
		
	}
	
	@RequestMapping(value= "/captura/Comparar", method = RequestMethod.GET)
	public String compareFingerPrint(@RequestParam("Digital") String digital) {	
				
		return digital;
		
	}
	
	@RequestMapping(value= "/captura/Enroll/1", method = RequestMethod.GET)
	public String enrollDigital() {	
		
				
		
		return ut.enrollDigital();
		
	}
	
	

}
