<html>
<body>
<h2>Hello World!</h2>
<button id="btn">呵呵呵</button>
  <script src="resource/js/jquery-1.8.3.min.js"></script>
  <script>
  $(function(){  
	  var arr=new Array();
	  arr.push({"xxx":"xxx"});
	  arr.push({"ccc":"ccc"});  
	  $("#btn").click(function (){ 
		  $.post(
			"http://localhost:8080/find/this",
			{   
				xxx:JSON.stringify(arr)   
			},
			function(data){
				
			}
		 );
	  });
	}); 
  </script>
</body>
</html>
