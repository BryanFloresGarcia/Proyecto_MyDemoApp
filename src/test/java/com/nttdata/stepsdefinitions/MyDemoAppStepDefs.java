package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyDemoAppSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MyDemoAppStepDefs {

    @Steps
    MyDemoAppSteps aplicativo;


    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        aplicativo.validoSiEstoyEnProductos();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        aplicativo.validoElementosCargados();
    }

    @When("agrego {string} del siguiente producto {string}")
    public void agregoProductosAlCarrito(String arg0, String arg1) {

        aplicativo.buscarProductoPorNombre(arg1);
        aplicativo.agregarCantidadDeProducto(arg0);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        aplicativo.verCarritoDeCompras();
        aplicativo.validoProductoAgregadoAlCarrito();
    }
}
