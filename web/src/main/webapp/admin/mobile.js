//ECMAScript 이벤트 핸들링 함수 : touchstart, touchend, touchmove, touchcancel,
// click, change, submit, keypress, keyup, keydown ... 
document.getElementById("btn").addEventListener("touchstart",function(){
	reviews();
})

function reviews()	{
	if(frm.mname.value==""){
		alert("고객명을 입력하세요.");
		frm.mname.focus(); //모바일은 필히 focus 넣어주면 좋다.
	}
	else if(frm.pname.value==""){
		alert("상품명을 입력하세요.");
		frm.pname.focus(); 
	}
	else if(frm.mtext.value==""){
		alert("리뷰내용을 입력하세요.");
		frm.mtext.focus(); 
	}
	else{
		frm.submit();
	}
}