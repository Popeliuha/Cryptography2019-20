//READ COMMENTS TO UNDERSTAND THE TECHNIQUE

(function(){

"use strict";


window.CeasarsCipher = function(input){
	var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase(),
  		shiftAmount,
      shiftedAlphabet = "",
      OUTPUT = "",
      STRING,
      otherCharacters = '-=~\"\'#$%&*^:<>?/!{(|)}.1234567890\, '
  if(typeof input === "object"){
		if (Math.abs(input.shift) >= 26) {input.shift = input.shift % 26}
  	shiftAmount = input.shift;

    STRING = input.msg.toLowerCase();
  } else {
  	return;
  }
  if(typeof STRING === "string" || typeof (STRING+"") === "string"){
    shiftedAlphabet = alphabet.slice(shiftAmount);
    shiftedAlphabet += alphabet.slice(0, shiftAmount);
	  shiftedAlphabet += otherCharacters;
		alphabet += otherCharacters;
		// shiftedAlphabet = shiftedAlphabet.replace(/[^A-Za-z]/g,"");
		for(var i = 0; i < STRING.length; i++){
    	var numberd = alphabet.indexOf( STRING[i] )
			// numberd -= 1;
  		OUTPUT += shiftedAlphabet[numberd];
			OUTPUT = OUTPUT.replace(/[^A-Za-z]/g,"");
    }
  } else {
    return;
  };
return OUTPUT;
};
})();

mess = document.getElementById("message");
if (mess) {
mess.addEventListener("input", function(){
	var itsValue = this.value;
  document.getElementById("output").textContent = CeasarsCipher({
  	msg: itsValue,
    shift: document.getElementById("shift").value
  });
});
}
else {
	console.log("none");
}
document.getElementById("shift").addEventListener("keyup", function(){
	var itsValue = this.value;
  document.getElementById("output").textContent = CeasarsCipher({
  	msg: document.getElementById("message").value,
    shift: itsValue
  })
});

document.getElementById("output").textContent = CeasarsCipher({
  	msg: document.getElementById("message").value,
    shift: document.getElementById("shift").value
  });
