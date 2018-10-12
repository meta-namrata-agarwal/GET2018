/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/*!********************!*\
  !*** ./src/app.js ***!
  \********************/
/*! no exports provided */
/*! all exports used */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("Object.defineProperty(__webpack_exports__, \"__esModule\", { value: true });\n/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__modules_math_functions__ = __webpack_require__(/*! ./modules/math-functions */ 2);\n\n\nresult.addEventListener(\"click\", function () {\n\n    const firstNumber = parseFloat(document.getElementById(\"firstNumber\").value);\n    const secondNumber = parseFloat(document.getElementById(\"secondNumber\").value);\n    const resultAdd = document.getElementById('resultAdd');\n    const resultProd = document.getElementById('resultProd');\n    resultAdd.innerHTML = `The sum of ${firstNumber} and ${secondNumber} is ${Object(__WEBPACK_IMPORTED_MODULE_0__modules_math_functions__[\"a\" /* add */])(firstNumber)(secondNumber)}.`;\n    resultProd.innerHTML = `The product of ${firstNumber} and ${secondNumber} is ${Object(__WEBPACK_IMPORTED_MODULE_0__modules_math_functions__[\"b\" /* prod */])(firstNumber)(secondNumber)}.`;\n\n});\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMC5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9hcHAuanM/N2FjOSJdLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge1xuICAgIGFkZCxcbiAgICBwcm9kXG59IGZyb20gJy4vbW9kdWxlcy9tYXRoLWZ1bmN0aW9ucyc7XG5cbnJlc3VsdC5hZGRFdmVudExpc3RlbmVyKFwiY2xpY2tcIiwgZnVuY3Rpb24gKCkge1xuXG4gICAgY29uc3QgZmlyc3ROdW1iZXIgPSBwYXJzZUZsb2F0KGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKFwiZmlyc3ROdW1iZXJcIikudmFsdWUpO1xuICAgIGNvbnN0IHNlY29uZE51bWJlciA9IHBhcnNlRmxvYXQoZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoXCJzZWNvbmROdW1iZXJcIikudmFsdWUpO1xuICAgIGNvbnN0IHJlc3VsdEFkZCA9IGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKCdyZXN1bHRBZGQnKTtcbiAgICBjb25zdCByZXN1bHRQcm9kID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoJ3Jlc3VsdFByb2QnKTtcbiAgICByZXN1bHRBZGQuaW5uZXJIVE1MID0gYFRoZSBzdW0gb2YgJHtmaXJzdE51bWJlcn0gYW5kICR7c2Vjb25kTnVtYmVyfSBpcyAke2FkZChmaXJzdE51bWJlcikoc2Vjb25kTnVtYmVyKX0uYDtcbiAgICByZXN1bHRQcm9kLmlubmVySFRNTCA9IGBUaGUgcHJvZHVjdCBvZiAke2ZpcnN0TnVtYmVyfSBhbmQgJHtzZWNvbmROdW1iZXJ9IGlzICR7cHJvZChmaXJzdE51bWJlcikoc2Vjb25kTnVtYmVyKX0uYDtcblxufSk7XG5cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9hcHAuanNcbi8vIG1vZHVsZSBpZCA9IDBcbi8vIG1vZHVsZSBjaHVua3MgPSAwIl0sIm1hcHBpbmdzIjoiQUFBQTtBQUFBO0FBR0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOyIsInNvdXJjZVJvb3QiOiIifQ==\n//# sourceURL=webpack-internal:///0\n");

/***/ }),
/* 1 */,
/* 2 */
/*!***************************************!*\
  !*** ./src/modules/math-functions.js ***!
  \***************************************/
/*! exports provided: add, prod */
/*! exports used: add, prod */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"a\", function() { return add; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"b\", function() { return prod; });\nconst add = (a, b) => (b || b === 0) ? a + b : (b) => a + b;\nconst prod = (a, b) => (b || b === 0) ? a * b : (b) => a * b;\n\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMi5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9tb2R1bGVzL21hdGgtZnVuY3Rpb25zLmpzP2VlOTciXSwic291cmNlc0NvbnRlbnQiOlsiY29uc3QgYWRkID0gKGEsIGIpID0+IChiIHx8IGIgPT09IDApID8gYSArIGIgOiAoYikgPT4gYSArIGI7XG5jb25zdCBwcm9kID0gKGEsIGIpID0+IChiIHx8IGIgPT09IDApID8gYSAqIGIgOiAoYikgPT4gYSAqIGI7XG5leHBvcnQge1xuICAgIGFkZCxcbiAgICBwcm9kXG59O1xuXG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9zcmMvbW9kdWxlcy9tYXRoLWZ1bmN0aW9ucy5qc1xuLy8gbW9kdWxlIGlkID0gMlxuLy8gbW9kdWxlIGNodW5rcyA9IDAiXSwibWFwcGluZ3MiOiJBQUFBO0FBQUE7QUFBQTtBQUNBO0FBSUE7Iiwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///2\n");

/***/ })
/******/ ]);