package org.longbow.jgrapetree.test.cases.io;

import java.util.Date;

import junit.framework.TestCase;

import org.jgrapetree.build.html.HtmlBuilder;
import org.jgrapetree.build.html.HtmlBuilderImpl;
import org.jgrapetree.model.Form;
import org.jgrapetree.model.Widget;
import org.jgrapetree.model.form.GrapeForm;
import org.jgrapetree.model.form.GrapeWidget;
import org.jgrapetree.model.form.GrapeWidgetManager;

public class HtmlBuildPerformanceCase extends TestCase {
	public void testChildren(){
		Form doc = generate();
		Widget root = doc.getRoot();

		Widget w0 = root.getChild(0).getChild(0).clone();
		Widget w1 = root.getChild(0).getChild(1).clone();
		Widget w2 = root.getChild(0).getChild(2).clone();
		root.getChild(0).addChild(w0);
		doc.addWidget(w0);
		root.getChild(0).addChild(w1);
		doc.addWidget(w1);
		root.getChild(0).addChild(w2);
		doc.addWidget(w2);
		
		
		HtmlBuilder builder = new HtmlBuilder();
		
		Date d1 = new Date();
		long longtime1 = d1.getTime();
		/**********************/
		int count = 0;
		for(int i = 0; i< 100; i++){
			builder.getString(doc);
			count++;
		}
		/**********************/
		Date d2 = new Date();
		long longtime2 = d2.getTime();
		long time = (longtime2 - longtime1);
		System.out.println("TOTAL:" + time + "ms, "+count+"Forms");
		System.out.println("PERFORMANCE:" + (time / count) + "ms / Form");
    }
	
	//

	private GrapeForm generate(){
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
