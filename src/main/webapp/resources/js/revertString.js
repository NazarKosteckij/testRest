 $(document).ready(function(){
		
		 $("#send").click(function(){ 
		  if($('#string').val()!== ""){
			 var str = null;
			 doRevertStringAjax();
		 	} else {
				$('.response').empty();
				$('.response').append('enter string');
		 	}
		 });
	 });