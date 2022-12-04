package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _05_DataTableSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    FormContent fc=new FormContent();

    @And("Click on the element on left nav")
    public void clickOnTheElementOnLeftNav(DataTable elemanlar) {

        List<String> listElemanlar = elemanlar.asList(String.class);

        for (String strButton : listElemanlar) {
            //System.out.println("eleman = " + elemanlar);
            ln.findAndClick(strButton);
        }
    }

    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elemanlar) {
        List<String> listElemanlar = elemanlar.asList(String.class);

        for (String strButtonName : listElemanlar) {
            dc.findAndClick(strButtonName);
        }

    }

    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elemanlar) {
        List<List<String>> listElemanlar = elemanlar.asLists(String.class);

        for (int i = 0; i < listElemanlar.size(); i++) {
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1));
                            // eleman adi                   eleman degeri
        }
    }

    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elemanlar) {
        List<String> listElemanlar = elemanlar.asList(String.class);

        for(String strButtonName : listElemanlar){
            dc.FindAndDelete(strButtonName);
        }
    }

    @And("Click on the element in the Form Content")
    public void clickOnTheElementInTheFormContent(DataTable elemanlar) {
        List<String> listElemanlar= elemanlar.asList(String.class);

        for(String strButtonName : listElemanlar)
            fc.findAndClick(strButtonName);
    }
}
