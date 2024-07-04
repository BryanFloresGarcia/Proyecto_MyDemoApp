package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyDemoAppScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")
    private WebElement titulo;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup")
    private List<WebElement> listaProductos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
    private WebElement cantProducto;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement incrementProducto;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement btnAgregarAlCarrito;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"View cart\"]")
    private WebElement btnCarrito;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]")
    private WebElement nomProdCarrito;


    public String getTituloProducto(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(titulo));
        return titulo.getText();
    }

    public int getCantDeElementos(){
        return listaProductos.size();
    }

    public String buscaProducto(String nomProducto){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        for(int i=1; i<= listaProductos.size();i++) {
            WebElement product = getDriver().findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\" and @text])["+i+"]"));

            if (nomProducto.equals(product.getText())){
                wait.until(ExpectedConditions.elementToBeClickable(product));
                product = getDriver().findElement(By.xpath("//android.widget.ImageView[@content-desc=\""+nomProducto+"\"]"));
                product.click();
                return nomProducto;
            }
        }
        return "Producto no encontrado";
    }

    public int agregarProducto(int cantProdDeseados){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnAgregarAlCarrito));

        new Actions(getDriver()).dragAndDrop(btnAgregarAlCarrito,btnCarrito).perform();

        wait.until(ExpectedConditions.elementToBeClickable(incrementProducto));
        for(int i=1;i<cantProdDeseados;i++){
            incrementProducto.click();
        }
        btnAgregarAlCarrito.click();
        return Integer.parseInt(cantProducto.getText());
    }

    public void clickEnCarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnCarrito));
        btnCarrito.click();
    }

    public String getTituloCarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(titulo));
        return titulo.getText();
    }

    public String getNombreDelProductoEnCarrito(){
        return nomProdCarrito.getText();
    }

    public int getCantidadDelProductoEnCarrito(){
        return Integer.parseInt(cantProducto.getText());
    }

}
