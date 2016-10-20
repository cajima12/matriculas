function clearssl() {
     try{
		window.crypto.logout(); 
		
     }catch(e){
    	try{
    		javascript:void(document.execCommand('ClearAuthenticationCache'));
    	 	
    	}catch(e2){ 
    	}
     }
}
  
function isendingsession( )
{		
	return		window.location.href.indexOf('/end', this.length - '/end'.length) !== -1;
       
}
function   isClearSSLEnabled(){
	if(navigator.userAgent.toLowerCase().indexOf('firefox') > -1)
	{
	 return true;    //Do Firefox-related activities
	}
	if (navigator.appName == 'Microsoft Internet Explorer'){
		return true;
	}
	 return false;
}