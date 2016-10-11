"use strict";
var core_1 = require("@angular/core");
var helloDuet_component_1 = require("./pages/helloDuet/helloDuet.component");
exports.routes = [
    { path: "", component: helloDuet_component_1.HelloDuetPage }
];
exports.navigatableComponents = [
    helloDuet_component_1.HelloDuetPage
];
var AppComponent = (function () {
    function AppComponent() {
    }
    AppComponent = __decorate([
        core_1.Component({
            selector: "main",
            template: "<page-router-outlet></page-router-outlet>"
        }), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map