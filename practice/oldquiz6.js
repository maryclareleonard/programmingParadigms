const x2 = "OUTER";
function second() {
  console.log(x2);
 }
function first() {
  const x2 = "FIRST";
  second();
}
first();
