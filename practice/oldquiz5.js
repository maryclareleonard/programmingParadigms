const x3 = 'X';
function f1(x3) {
  console.log(x3);
}
function f2() {
  const	x3 = 'Y';
  f1(x3);
}
f2();
f1(x3);
