import {
    add,
    prod
} from './modules/math-functions';

result.addEventListener("click", function () {

    const firstNumber = parseFloat(document.getElementById("firstNumber").value);
    const secondNumber = parseFloat(document.getElementById("secondNumber").value);
    const resultAdd = document.getElementById('resultAdd');
    const resultProd = document.getElementById('resultProd');
    resultAdd.innerHTML = `The sum of ${firstNumber} and ${secondNumber} is ${add(firstNumber)(secondNumber)}.`;
    resultProd.innerHTML = `The product of ${firstNumber} and ${secondNumber} is ${prod(firstNumber)(secondNumber)}.`;

});
