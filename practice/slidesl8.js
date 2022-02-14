function second3(f) {
  const name = 'new';
  f();
}

function first3() {
  const name = 'old';
  const printName = () => console.log(name);
  second3(printName);
}

first3();
