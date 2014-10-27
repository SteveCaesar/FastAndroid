// Generated code from Butter Knife. Do not modify!
package com.example.demo.controller;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ListImageActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demo.controller.ListImageActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165189, "field 'lv_image'");
    target.lv_image = (android.widget.ListView) view;
  }

  public static void reset(com.example.demo.controller.ListImageActivity target) {
    target.lv_image = null;
  }
}
