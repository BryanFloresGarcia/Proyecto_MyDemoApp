package com.nttdata.steps;

import com.nttdata.screens.MyDemoAppScreen;
import org.junit.Assert;

public class MyDemoAppSteps {
    MyDemoAppScreen appScreen;

    public void validoSiEstoyEnProductos(){
        Assert.assertEquals("Products", appScreen.getTituloProducto());
    }

    public void validoElementosCargados(){
        Assert.assertEquals(4,appScreen.getCantDeElementos());

    }

    public void buscarProductoPorNombre(String nomProducto){
        Assert.assertEquals(nomProducto,appScreen.buscaProducto(nomProducto));
    }

    public void agregarCantidadDeProducto(String cprod){
        Assert.assertEquals(Integer.parseInt(cprod),appScreen.agregarProducto(Integer.parseInt(cprod)));
    }

    public void verCarritoDeCompras(){
        appScreen.clickEnCarrito();
        Assert.assertEquals("My Cart",appScreen.getTituloCarrito());
    }

    public void validoProductoAgregadoAlCarrito(){
        Assert.assertNotNull(appScreen.getNombreDelProductoEnCarrito());
        Assert.assertTrue(appScreen.getCantidadDelProductoEnCarrito()>0);
    }

}
