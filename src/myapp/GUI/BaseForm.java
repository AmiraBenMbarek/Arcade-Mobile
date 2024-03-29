/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package myapp.GUI;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import myapp.MyApplication;
import com.codename1.ui.util.Resources;
import myapp.Entities.User;

/**
 * Base class for the forms with common functionality
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {

    public BaseForm() {
    }

    public BaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public BaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(255);
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    protected void addSideMenu() {
        Toolbar tb = getToolbar();
        tb.setSafeArea(false);
        
        
        tb.addMaterialCommandToSideMenu("Users", FontImage.MATERIAL_PEOPLE, e -> new affichageuser().show());
        tb.addMaterialCommandToSideMenu("Categories", FontImage.MATERIAL_CATEGORY, e -> new afficherCategorieForm().show());
        tb.addMaterialCommandToSideMenu("Produits", FontImage.MATERIAL_SHOPPING_BAG, e -> new ListProductsForm().show());
        //tb.addMaterialCommandToSideMenu("Panier", FontImage.MATERIAL_SHOPPING_CART, e -> new ListCartsForm().show());
        tb.addMaterialCommandToSideMenu("Jeux", FontImage.MATERIAL_SPORTS_ESPORTS, e -> new affichage().show());
        
        tb.addMaterialCommandToSideMenu("Events", FontImage.MATERIAL_EVENT, e -> new afficherEvenementForm().show());
        //tb.addMaterialCommandToSideMenu("Sponsors", FontImage.MATERIAL_ATTACH_MONEY, e -> new affichage().show());

        tb.addMaterialCommandToSideMenu("Coaching", FontImage.MATERIAL_SPORTS, e -> new affichageSeance().show());
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_LOGOUT, e -> {
            MyApplication.loggedUser = new User();
            Form p1 = new SignInForm();
            p1.show();
        });
        
    }
}
