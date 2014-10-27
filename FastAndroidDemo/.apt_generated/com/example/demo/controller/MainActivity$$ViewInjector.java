// Generated code from Butter Knife. Do not modify!
package com.example.demo.controller;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demo.controller.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165190, "field 'btn_database' and method 'on'");
    target.btn_database = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.on(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165192, "field 'btn_appExButton' and method 'on'");
    target.btn_appExButton = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.on(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165191, "field 'btn_network' and method 'on'");
    target.btn_network = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.on(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165193, "method 'on'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.on(p0);
        }
      });
  }

  public static void reset(com.example.demo.controller.MainActivity target) {
    target.btn_database = null;
    target.btn_appExButton = null;
    target.btn_network = null;
  }
}
