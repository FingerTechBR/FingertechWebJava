package com.FingerTechWeb.FingertechAPIWeb.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nitgen.SDK.BSP.NBioBSPJNI;

@RestController
@RequestMapping("/v1")
public class CaptureController {
	NBioBSPJNI bsp;
	
	
	
	
	@RequestMapping(value= "/capturesingle/", method = RequestMethod.GET)
	public boolean captureSingleFinger() {
		
		bsp = new NBioBSPJNI();
		bsp.OpenDevice();		
		NBioBSPJNI.FIR_HANDLE captura = bsp.new FIR_HANDLE();	
		bsp.Capture(captura);		
		return true;
		
	}
	
	
	

}
