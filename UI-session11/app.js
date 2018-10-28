var myApp = angular.module('groceryCart', ['ngRoute']);

myApp.config(function ($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider
        .when('/', {
            templateUrl: 'pages/home.html',
            controller: 'mainController'
        })
        .when('/category/:categoryName', {
            templateUrl: 'pages/home.html',
            controller: 'mainController'
        })
        .when('/cart', {
            templateUrl: 'pages/cart.html',
            controller: 'cartController'
        })
        .when('/check-out', {
            templateUrl: 'pages/checkOut.html',
            controller: 'checkOutController'
        })
        .when('/order-success', {
            templateUrl: 'pages/orderStatus.html',
            controller: 'orderStatusController'
        })
});

myApp.controller('mainController', function ($scope, $routeParams, $http, $rootScope) {
    $rootScope.userName = "John Doe";
    $rootScope.itemCount;
    $scope.addQuantity = 0;
    $scope.categoryName = $routeParams.categoryName;
    $http.get('http://localhost:3000/categories').then(function (response) {
        $scope.categoryList = response.data;
    });

    $http.get('http://localhost:3000/items').then(function (response) {
        $scope.items = response.data;
    });

    $http.get('http://localhost:3000/carts').then(function (response) {
        $scope.cartItem = response.data;
        $scope.Count = 0;
        for (var item in $scope.cartItem) {
            $scope.Count += $scope.cartItem[item].quantity;
        }
        $rootScope.itemCount = $scope.Count;
    });

    $scope.showQuantityInCart = function (productId) {
        for (var i = 0; i < $scope.cartItem.length; i++) {
            var result = $scope.cartItem[i];
            if (result.id === productId) {
                $scope.addQuantity = result.quantity;
                return $scope.addQuantity;
            }
        }
        return 0;
    }
    $scope.addToCart = function (product) {
        $http.get('http://localhost:3000/carts').then(function (response) {
            var cartData = {
                "id": product.id,
                "name": product.name,
                "price": product.price,
                "description": product.description,
                "image": product.image,
                "category": product.category,
                "quantity": 1
            }
            $http({
                method: 'POST',
                url: 'http://localhost:3000/carts/',
                data: cartData,
                dataType: 'json',
            });
        });
        window.location.reload();
    };
    $scope.addQuantityToCart = function (product) {
        $http.get('http://localhost:3000/carts/' + product.id).then(function (response) {
            response.data.quantity += 1;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/carts/' + product.id,
                data: response.data,
                dataType: 'json'
            });
            $http.get('http://localhost:3000/carts').then(function (response) {
                $scope.cartItem = response.data;
                $scope.Count = 0;
                for (var item in $scope.cartItem) {
                    $scope.Count += $scope.cartItem[item].quantity;
                }
                $rootScope.itemCount = $scope.Count;
            });
        });
    };
    $scope.removeQuantity = function (product) {
        $http.get('http://localhost:3000/carts/' + product.id).then(function (response) {
            response.data.quantity -= 1;
            if (response.data.quantity >= 1) {
                $http({
                    method: 'PUT',
                    url: 'http://localhost:3000/carts/' + product.id,
                    data: response.data,
                    dataType: 'json'
                });
            } else {
                $http({
                    method: 'DELETE',
                    url: 'http://localhost:3000/carts/' + product.id,
                    data: response.data,
                    dataType: 'json'
                });
                window.location.reload();
            }
            $http.get('http://localhost:3000/carts').then(function (response) {
                $scope.cartItem = response.data;
                $scope.Count = 0;
                for (var item in $scope.cartItem) {
                    $scope.Count += $scope.cartItem[item].quantity;
                }
                $rootScope.itemCount = $scope.Count;
            });
        });
    };
});

myApp.controller('cartController', function ($scope, $http, $rootScope) {
    $scope.totalPrice = 0;
    $http.get('http://localhost:3000/carts').then(function (response) {
        $scope.cartItem = response.data;
        $scope.Count = 0;
        $scope.totalPrice = 0;
        for (var item in $scope.cartItem) {
            $scope.Count += $scope.cartItem[item].quantity;
            $scope.totalPrice += $scope.cartItem[item].quantity * $scope.cartItem[item].price;
        };
        $rootScope.itemCount = $scope.Count;
    });
    $scope.addQuantityToCart = function (product) {
        $http.get('http://localhost:3000/carts/' + product.id).then(function (response) {
            response.data.quantity += 1;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/carts/' + product.id,
                data: response.data,
                dataType: 'json'
            });
            $http.get('http://localhost:3000/carts').then(function (response) {
                $scope.cartItem = response.data;
                $scope.Count = 0;
                $scope.totalPrice = 0;
                for (var item in $scope.cartItem) {
                    $scope.Count += $scope.cartItem[item].quantity;
                    $scope.totalPrice += $scope.cartItem[item].quantity * $scope.cartItem[item].price;
                }
                $rootScope.itemCount = $scope.Count;
            });
        });
    };
    $scope.removeQuantity = function (product) {
        $http.get('http://localhost:3000/carts/' + product.id).then(function (response) {
            response.data.quantity -= 1;
            if (response.data.quantity >= 1) {
                $http({
                    method: 'PUT',
                    url: 'http://localhost:3000/carts/' + product.id,
                    data: response.data,
                    dataType: 'json'
                });
            } else {
                $http({
                    method: 'DELETE',
                    url: 'http://localhost:3000/carts/' + product.id,
                    data: response.data,
                    dataType: 'json'
                });
            }
            $http.get('http://localhost:3000/carts').then(function (response) {
                $scope.cartItem = response.data;
                $scope.Count = 0;
                $scope.totalPrice = 0;
                for (var item in $scope.cartItem) {
                    $scope.Count += $scope.cartItem[item].quantity;
                    $scope.totalPrice += $scope.cartItem[item].quantity * $scope.cartItem[item].price;
                }
                $rootScope.itemCount = $scope.Count;
            });
        });
    };
    $scope.deleteAll = function () {
        $http.get('http://localhost:3000/carts').then(function successCallback(response) {
            $scope.cartItem = response.data;
            if (response.data.length != 0) {
                var item = 1;
                for (item in $scope.cartItem) {
                    $http.delete('http://localhost:3000/carts/' + $scope.cartItem[item].id, item).then(function (response) {
                        $scope.message = "Cart is Empty!!";
                    });
                };
                $rootScope.itemCount = 0;
                $scope.totalPrice = 0;
                $http.get('http://localhost:3000/carts').then(function (response) {
                    $scope.cartItem = response.data;
                });
            };
        });
    }
});

myApp.controller('checkOutController', function ($scope, $http) {
    $scope.totalPrice = 0;
    $http.get('http://localhost:3000/carts').then(function (response) {
        $scope.cartItem = response.data;
        var item;
        for (item in $scope.cartItem) {
            $scope.totalPrice = $scope.cartItem[item].price * $scope.cartItem[item].quantity + $scope.totalPrice;
        }
    });
});

myApp.controller('orderStatusController', function ($scope, $http, $rootScope) {
    $http.get('http://localhost:3000/carts').then(function successCallback(response) {
        $scope.cartItem = response.data;
        if (response.data.length != 0) {
            var item = 1;
            for (item in $scope.cartItem) {
                $http.delete('http://localhost:3000/carts/' + $scope.cartItem[item].id, item).then(function (response) {
                    $scope.status = "Thank You!";
                    $scope.message = "We received your order and will process it within next 24 hours";
                });
            };
            $rootScope.itemCount = 0;
        } else {
            $scope.status = "Sorry!";
            $scope.message = "Your order coudnot be placed. Please Try again!!";
        }
    });
});
