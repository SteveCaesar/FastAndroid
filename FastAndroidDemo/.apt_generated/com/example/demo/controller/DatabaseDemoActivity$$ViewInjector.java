// Generated code from Butter Knife. Do not modify!
package com.example.demo.controller;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DatabaseDemoActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demo.controller.DatabaseDemoActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165184, "field 'btn_createDatabase' and method 'onClick'");
    target.btn_createDatabase = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165188, "field 'btn_query' and method 'onClick'");
    target.btn_query = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165187, "field 'btn_update' and method 'onClick'");
    target.btn_update = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165185, "field 'btn_insert' and method 'onClick'");
    target.btn_insert = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165186, "field 'btn_delete' and method 'onClick'");
    target.btn_delete = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  public static void reset(com.example.demo.controller.DatabaseDemoActivity target) {
    target.btn_createDatabase = null;
    target.btn_query = null;
    target.btn_update = null;
    target.btn_insert = null;
    target.btn_delete = null;
  }
}
