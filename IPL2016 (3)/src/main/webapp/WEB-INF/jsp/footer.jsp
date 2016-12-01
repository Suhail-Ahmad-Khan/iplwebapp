	<%-- 
		These two div tags are opened in header.
		All the content except header and footer are written in side container div
		Do not assume that these div are useless 
	--%>
		
	</div> <!-- CLOSED container div -->
</div>  <!-- CLOSED wrapper div -->
	
<div class="footer_wrapper">
	<div class="footer">
		<div class="copyright">&copy; 2014 by springtest.com. All Rights Reserved.</div>
	</div>
</div>
<input type="hidden" id="refreshed" value="no" >
<script type="text/javascript">
var el = document.getElementById("refreshed");
if(el.value==="no"){
	el.value = "yes";
}
else{
	el.value = "no";
	window.location.reload();
}
</script>
</body>
</html>