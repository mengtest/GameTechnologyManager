//刷新验证码
	 function changeImg() { 
        var imgSrc = $("#imgObj"); 
        var src = imgSrc.attr("src"); 
        imgSrc.attr("src", chgUrl(src)); 
    }
     //时间戳     
    //为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳     
    function chgUrl(url) { 
        var timestamp = (new Date()).valueOf();
        if ((url.indexOf("?") >= 0)) { 
            url = url.substring(0,url.indexOf("?"));
        } 
         url = url + "?timestamp=" + timestamp; 
        return url; 
    }
    function checkCode(){
    	var code = $("#checkCode").val();
    	var flag = false;
    	if(code == ""){
    		alert("请输入验证码！");
    	} else {
    		$.ajax({
    			 url:'checkCode/' + code,
    			 async:false,
    			 type:'post',
    			 contentType:'application/json' ,
    				dataType:'json',
    				error:function(data){alert("系统错误....");},
    				success:function(data){
    					if(data.ok == 1){
    						flag =  true;
    					} else {
    						alert("验证码错误");
    					}
    				}	
    		 });	
    	}
    	return flag;
    	
    }
    function login(){
    	if(checkCode()){
    		var code = $("#checkCode").val();
    		var name = $("#name").val();
    		var password = $("#password").val();
    		$.ajax({
    			url:'member/checkMember',
    			data:''
    		});
    	}
    }
    
    $(document).ready(function(){
    	$("#checkCode").blur(function(){
    		checkCode();
    	});
    });