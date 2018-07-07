var domain = 'http://onmovvvw3.bkt.clouddn.com/';

var imgJson = {
	"phonelogo":"JF_phoneLogo",
	"pclogo":"JF_pclogo",
	"bannerA":"JF_a1",
	"bannerB":"JF_a2",
	"bannerC":"JF_a3",
	"imgA":"JF_ImgA",
	"imgB":"JF_ImgB",
	"imgC":"JF_ImgC",
	"imgD":"JF_ImgD",
	"imgE":"JF_ImgE",
	"imgF":"JF_ImgF",
	"imgG":"JF_ImgG",
	"imgH":"JF_ImgH",
	"imgJ":"JF_ImgJ",
	"smallLogo":"JF_SmallLogo",
	"qrcode":"JF_qcode",
	"storyBanner":"JF_story",
	"shopBanner":"JF_shop"
}

var initImgSrc = function(){
	for(var key in imgJson){
		if($('#'+key)){
			$('#'+key).attr('src',domain+imgJson[key]);
		}
	}
}

initImgSrc();