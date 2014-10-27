// Generated code from Butter Knife. Do not modify!
package com.example.demo.controller;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class NetworkActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demo.controller.NetworkActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165196, "field 'btn_jsonToObject' and method 'onClick'");
    target.btn_jsonToObject = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165197, "field 'btn_getImage' and method 'onClick'");
    target.btn_getImage = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165194, "field 'rim_image'");
    target.rim_image = (com.fastandroid.mvc.view.RecyclingImageView) view;
    view = finder.findRequiredView(source, 2131165200, "field 'btn_download' and method 'onClick'");
    target.btn_download = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165198, "field 'btn_getImage2' and method 'onClick'");
    target.btn_getImage2 = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165195, "field 'btn_getText' and method 'onClick'");
    target.btn_getText = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165199, "field 'btn_getListImage' and method 'onClick'");
    target.btn_getListImage = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  public static void reset(com.example.demo.controller.NetworkActivity target) {
    target.btn_jsonToObject = null;
    target.btn_getImage = null;
    target.rim_image = null;
    target.btn_download = null;
    target.btn_getImage2 = null;
    target.btn_getText = null;
    target.btn_getListImage = null;
  }
}
