var myApp = angular.module('userManagementApp', []);
myApp.controller('UserListController', UserListController);

function UserListController($scope, $http) {

    $http.get('users.json').then(function (response) {
        $scope.users = response.data;
    });
    $scope.totalUser = 4;
    $scope.addUser = function (name, phone, adress) {
        if ($scope.name != "" && $scope.phone != "" && $scope.address != "") {
            $scope.users.push({
                'id': $scope.totalUser + 1,
                'name': $scope.name,
                'phone': $scope.phone,
                'address': $scope.address
            });
        } else {
            alert("Please fill the fields!!");
        }

        $scope.name = '';
        $scope.phone = '';
        $scope.address = '';;
    };

    $scope.setUserid = function (key) {
        $scope.users.forEach(element => {
            if (key === element.id) {
                $scope.id = element.id;
                $scope.editedName = element.name;
                $scope.editedPhone = element.phone;
                $scope.editedAddress = element.address;
            }
        });
    };

    $scope.editUser = function () {
        $scope.users.forEach(element => {
            if (element.id == $scope.id) {
                element.name = $scope.editedName;
                element.phone = $scope.editedPhone;
                element.address = $scope.editedAddress;
            }
        });
    }

}
