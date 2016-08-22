"use strict";
var core_1 = require("@angular/core");
var router_deprecated_1 = require("@angular/router-deprecated");
var ns_router_deprecated_1 = require("nativescript-angular/router-deprecated/ns-router-deprecated");
var helloDuet_component_1 = require("./pages/helloDuet/helloDuet.component");
var AppComponent = (function () {
    function AppComponent() {
    }
    AppComponent = __decorate([
        core_1.Component({
            selector: "main",
            directives: [ns_router_deprecated_1.NS_ROUTER_DIRECTIVES],
            providers: [ns_router_deprecated_1.NS_ROUTER_PROVIDERS],
            template: "<page-router-outlet></page-router-outlet>"
        }),
        router_deprecated_1.RouteConfig([
            { path: "/HelloDuet", component: helloDuet_component_1.HelloDuetPage, name: "Hello Duet", useAsDefault: true }
        ]), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map