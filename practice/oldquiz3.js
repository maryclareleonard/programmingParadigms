function f0(flag,f1,f2){
  if(flag===1)
	f1();
  else
	f2();
}
let f3 = () => console.log( "f3" );
let f4 = () => console.log( "f4" );
f0(1,f3,f4);
