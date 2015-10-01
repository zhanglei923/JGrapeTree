package org.longbow.jgrapetree.test.cases;
import org.jgrapetree.model.form.GrapeForm;
import org.jgrapetree.model.form.GrapeWidget;
import org.jgrapetree.model.form.GrapeWidgetManager;

/* 
 * Copyright (c) 2014 ZhangLei
 * 
 * Author: ZhangLei
 * Homepage: https://github.com/zhanglei923 
 * Email: zhang.lei.923@gmail.com 
 * 
 * Under the term of the MIT License
 * http://www.opensource.org/licenses/mit-license.php
 */

public class TreeGenerator {
	public GrapeForm generateForm(){
		GrapeWidget n0 = generateTree();
		GrapeForm form = new GrapeForm();
        form.addWidget(n0);
        return form;
	}	
	public GrapeWidget generateTree(){
		/**
		 *               0
		 *            /  |   \
		 *           1   3     2
		 *         /  \  |    /  \
		 *       11   12 31  21   22
		 *     /  \  / \    /  \  /  \
	  	 *    a   b c   d  e   f g    h
		 */
		GrapeWidget n0 = new GrapeWidget();n0.setAttr("name", "n0");
        GrapeWidget n1 = new GrapeWidget();n1.setAttr("name", "n1");
        GrapeWidget n2 = new GrapeWidget();n2.setAttr("name", "n2");
        GrapeWidget n3 = new GrapeWidget();n3.setAttr("name", "n3");
        GrapeWidget n11 = new GrapeWidget();n11.setAttr("name", "n11");
        GrapeWidget n12 = new GrapeWidget();n12.setAttr("name", "n12");
        GrapeWidget n21 = new GrapeWidget();n21.setAttr("name", "n21");
        GrapeWidget n22 = new GrapeWidget();n22.setAttr("name", "n22");
        GrapeWidget n31 = new GrapeWidget();n31.setAttr("name", "n31");
        GrapeWidget na = new GrapeWidget();na.setAttr("name", "na");
        GrapeWidget nb = new GrapeWidget();nb.setAttr("name", "nb");
        GrapeWidget nc = new GrapeWidget();nc.setAttr("name", "nc");
        GrapeWidget nd = new GrapeWidget();nd.setAttr("name", "nd");
        GrapeWidget ne = new GrapeWidget();ne.setAttr("name", "ne");
        GrapeWidget nf = new GrapeWidget();nf.setAttr("name", "nf");
        GrapeWidget ng = new GrapeWidget();ng.setAttr("name", "ng");
        GrapeWidget nh = new GrapeWidget();nh.setAttr("name", "nh");
        
        n0.addChild(n1);
        n0.addChild(n3);
        n0.addChild(n2);        
        //
        n1.addChild(n11);
        n1.addChild(n12);
        n3.addChild(n31);
        n2.addChild(n21);
        n2.addChild(n22);        
        //
        n11.addChild(na);
        n11.addChild(nb);
        n12.addChild(nc);
        n12.addChild(nd);
        n21.addChild(ne);
        n21.addChild(nf);
        n22.addChild(ng);
        n22.addChild(nh);
        
        return n0;
	}

	public GrapeForm generateForm2(){
		/**
		 * 				root
		 * 				 |
		 *               0
		 *            /  |   \
		 *           1   3     2
		 *         /  \  |    /  \
		 *       11   12 31  21   22
		 *     /  \  / \    /  \  /  \
	  	 *    a   b c   d  e   f g    h
		 */
		GrapeWidget n_root = new GrapeWidget();n_root.setAttr("name", "n_root");n_root.setAttr("caption", "n_root");n_root.setAttr("type", "form");
		GrapeWidget n0 = new GrapeWidget();n0.setAttr("name", "n0");n0.setAttr("caption", "n0");n0.setAttr("type", "container");
		GrapeWidget n1 = new GrapeWidget();n1.setAttr("name", "n1");n1.setAttr("caption", "n1");n1.setAttr("type", "container");
		GrapeWidget n2 = new GrapeWidget();n2.setAttr("name", "n2");n2.setAttr("caption", "n2");n2.setAttr("type", "container");
		GrapeWidget n3 = new GrapeWidget();n3.setAttr("name", "n3");n3.setAttr("caption", "n3");n3.setAttr("type", "container");
		GrapeWidget n11 = new GrapeWidget();n11.setAttr("name", "n11");n11.setAttr("caption", "n11");n11.setAttr("type", "container");
		GrapeWidget n12 = new GrapeWidget();n12.setAttr("name", "n12");n12.setAttr("caption", "n12");n12.setAttr("type", "container");
        GrapeWidget n21 = new GrapeWidget();n21.setAttr("name", "n21");n21.setAttr("caption", "n21");n21.setAttr("type", "container");
        GrapeWidget n22 = new GrapeWidget();n22.setAttr("name", "n22");n22.setAttr("caption", "n22");n22.setAttr("type", "container");
        GrapeWidget n31 = new GrapeWidget();n31.setAttr("name", "n31");n31.setAttr("caption", "n31");n31.setAttr("type", "button");
        GrapeWidget na = new GrapeWidget();na.setAttr("name", "na");na.setAttr("caption", "na");na.setAttr("type", "field");
        GrapeWidget naa = new GrapeWidget();naa.setAttr("name", "naa");naa.setAttr("caption", "naa");naa.setAttr("type", "field");
        GrapeWidget nb = new GrapeWidget();nb.setAttr("name", "nb");nb.setAttr("caption", "nb");nb.setAttr("type", "field");
        GrapeWidget nbb = new GrapeWidget();nbb.setAttr("name", "nbb");nbb.setAttr("caption", "nbb");nbb.setAttr("type", "field");
        
        GrapeWidget nc = new GrapeWidget();nc.setAttr("name", "nc");nc.setAttr("caption", "nc");nc.setAttr("type", "field");
        GrapeWidget ncc = new GrapeWidget();ncc.setAttr("name", "ncc");ncc.setAttr("caption", "ncc");ncc.setAttr("type", "field");
        GrapeWidget nd = new GrapeWidget();nd.setAttr("name", "nd");nd.setAttr("caption", "nd");nd.setAttr("type", "field");
        GrapeWidget ndd = new GrapeWidget();ndd.setAttr("name", "ndd");ndd.setAttr("caption", "ndd");ndd.setAttr("type", "field");
        
        GrapeWidget ne = new GrapeWidget();ne.setAttr("name", "ne");ne.setAttr("caption", "ne");ne.setAttr("type", "field");
        GrapeWidget nf = new GrapeWidget();nf.setAttr("name", "nf");nf.setAttr("caption", "nf");nf.setAttr("type", "field");
        
        GrapeWidget ng = new GrapeWidget();ng.setAttr("name", "ng");ng.setAttr("caption", "ng");ng.setAttr("type", "field");
        GrapeWidget nh = new GrapeWidget();nh.setAttr("name", "nh");nh.setAttr("caption", "nh");nh.setAttr("type", "field");
        
        n_root.addChild(n0);
        
        n0.addChild(n1);
        n0.addChild(n3);
        n0.addChild(n2);        
        //
        n1.addChild(n11);
        n1.addChild(n12);
        n3.addChild(n31);
        n2.addChild(n21);
        n2.addChild(n22);        
        //
        n11.addChild(na);
        n11.addChild(naa);
        n11.addChild(nb);
        n11.addChild(nbb);
        n12.addChild(nc);
        n12.addChild(ncc);
        n12.addChild(nd);
        n12.addChild(ndd);
        n21.addChild(ne);
        n21.addChild(nf);
        n22.addChild(ng);
        n22.addChild(nh);
        
        GrapeForm form = new GrapeForm();
        form.addWidget(n_root);
        
        
        return form;
	}
}
