 var img_src = new Array('/dokogacha/img/good_pink.png');
      var i = 0;
 function change() {

        if (i == 1) {
          i = 0;
        }
        document.getElementById('goodbutton').src = img_src[i];
      }