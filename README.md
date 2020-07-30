# CameraHandler
  
 
   		allprojects {
	 		repositories {
			...
	  			maven { url 'https://jitpack.io' }
		 	}
	 	}
  
 
 
 
 		dependencies {
	        	implementation 'com.github.developeramit3:CameraHandler:ad1da9dfba'
		}



		 CameraOptions cameraOptions = CameraOptions.init()
                .setRequestCode(100)
                .setCount(5)
                .setFrontfacing(false)
                .setScreenOrientation(CameraOptions.SCREEN_ORIENTATION_PORTRAIT);
		
		    
		 CameraHandler.start(MainActivity.this, cameraOptions);

[![](https://jitpack.io/v/developeramit3/CameraHandler.svg)](https://jitpack.io/#developeramit3/CameraHandler)
