const p = [1,4,9];
const q = [1,4,9]
function f(p,q){
  p = [1,1,1];
  q[2]=16;
}
f(p,q);
console.log(p,q);
