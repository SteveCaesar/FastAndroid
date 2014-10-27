// Generated code from Butter Knife. Do not modify!
package com.example.demo.controller;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SimpleDownloadActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demo.controller.SimpleDownloadActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165202, "field 'btn_start' and method 'onClick'");
    target.btn_start = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165201, "field 'tv_progress'");
    target.tv_progress = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131165203, "field 'btn_pause' and method 'onClick'");
    target.btn_pause = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165204, "field 'btn_stop' and method 'onClick'");
    target.btn_stop = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  public static void reset(com.example.demo.controller.SimpleDownloadActivity target) {
    target.btn_start = null;
    target.tv_progress = null;
    target.btn_pause = null;
    target.btn_stop = null;
  }
}
