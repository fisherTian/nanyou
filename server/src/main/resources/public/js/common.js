var menuFlag = false;

function showMenu(e){
	e.stopPropagation();
	menuFlag = !menuFlag;
	if(menuFlag){
		$('#appMenuBox').show();
	}else{
		$('#appMenuBox').hide();
	}
}

$("body").bind("click", function (event) {
	menuFlag = false;
	$('#appMenuBox').hide();
});