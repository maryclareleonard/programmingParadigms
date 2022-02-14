function f1(fn) {
  let x = 'second';
  fn();
}
function f2() {
  let x = 'first';
  let newfunc = () => console.log(x);
  f1(newfunc);
}
f2();
