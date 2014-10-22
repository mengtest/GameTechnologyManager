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
    		$("#msg").html("请输入验证码");
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
    						$("#msg").html("验证码错误！");
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
    			type:'post',
    			url:'member/checkMember',
    			dataType:"json",
    		    contentType:'application/json;charset=UTF-8',
    			data:JSON.stringify({name:name,password:password,code:code}),
    			
    			error:function(data) {alert("网络错误，请稍后再试.....");},
    			success:function(data){
    				if(data == 1){
    					$("#msg").html("用户不存在");
    				} else if(data == 2){
    					$("#msg").html("用户或密码错误");
    				} else if(data == 3){
    					$("#msg").html("验证码错误");
    				} else {
    					$("#msg").html("");
    					$("#loginForm").submit();
    				}
    			}
    		});
    	}
    }
    //jquery-ui中，用于格式化date日期
    function formatDate(val, row) {
		var datetime = new Date();
		datetime.setTime(val);
		var year = datetime.getFullYear();
		var month = datetime.getMonth() + 1 < 10 ? "0"
				+ (datetime.getMonth() + 1) : datetime.getMonth() + 1;
		var date = datetime.getDate() < 10 ? "0" + datetime.getDate()
				: datetime.getDate();
		var hour = datetime.getHours() < 10 ? "0" + datetime.getHours()
				: datetime.getHours();
		var minute = datetime.getMinutes() < 10 ? "0"
				+ datetime.getMinutes() : datetime.getMinutes();
		var second = datetime.getSeconds() < 10 ? "0"
				+ datetime.getSeconds() : datetime.getSeconds();
		return year + "-" + month + "-" + date + " " + hour + ":" + minute
				+ ":" + second;
	}
   