const add = (a, b) => (b || b === 0) ? a + b : (b) => a + b;
const prod = (a, b) => (b || b === 0) ? a * b : (b) => a * b;
export {
    add,
    prod
};
