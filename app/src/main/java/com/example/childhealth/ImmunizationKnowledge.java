package com.example.childhealth;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ImmunizationKnowledge extends AppCompatActivity implements View.OnClickListener {
    private WebView webView;
    private String currentHtmlFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immunization_knowledge);

        // Initialize WebView
        webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient());

        // Find all TextViews
        TextView[] textViews = {
                findViewById(R.id.immunizationTextView),
                findViewById(R.id.immunizationTableTextView),
                findViewById(R.id.tetanusTextView),
                findViewById(R.id.bcgTextView),
                findViewById(R.id.hepatitisTextView),
                findViewById(R.id.polioTextView),
                findViewById(R.id.dptTextView),
                findViewById(R.id.pentavalentTextView),
                findViewById(R.id.rotavirusTextView),
                findViewById(R.id.measlesRubellaTextView),
                findViewById(R.id.vitaminATextView),
                findViewById(R.id.vaccinesSensitiveTextView),
                findViewById(R.id.importanceThingsTextView),
                findViewById(R.id.childMilestoneTextView)
        };

        // Set OnClickListener for all TextViews
        for (TextView textView : textViews) {
            textView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        // Handle click events for all TextViews
        String htmlFileName = null;
        switch (v.getId()) {
            case R.id.immunizationTextView:
                htmlFileName = "Immunization.html";
                break;
            case R.id.immunizationTableTextView:
                htmlFileName = "ImmunizationTable.html";
                break;
            case R.id.tetanusTextView:
                htmlFileName = "Tetanus.html";
                break;
            case R.id.bcgTextView:
                htmlFileName = "BCG.html";
                break;
            case R.id.hepatitisTextView:
                htmlFileName = "Hepatitis.html";
                break;
            case R.id.polioTextView:
                htmlFileName = "Polio.html";
                break;
            case R.id.dptTextView:
                htmlFileName = "DPT.html";
                break;
            case R.id.pentavalentTextView:
                htmlFileName = "Pentavalent.html";
                break;
            case R.id.rotavirusTextView:
                htmlFileName = "Rotavirus.html";
                break;
            case R.id.measlesRubellaTextView:
                htmlFileName = "Measel.html";
                break;
            case R.id.vitaminATextView:
                htmlFileName = "VitaminA.html";
                break;
            case R.id.vaccinesSensitiveTextView:
                htmlFileName = "SensitiveVaccine.html";
                break;
            case R.id.importanceThingsTextView:
                htmlFileName = "ImportanceThings.html";
                break;
            case R.id.childMilestoneTextView:
                htmlFileName = "ChildMilestone.html";
                break;
        }

        if (htmlFileName != null && !htmlFileName.equals(currentHtmlFileName)) {
            currentHtmlFileName = htmlFileName;
            loadHtmlFile(htmlFileName);
        }
    }

    private void loadHtmlFile(String htmlFileName) {
        // Load HTML file in WebView
        setContentView(webView);
        webView.setVisibility(View.VISIBLE);
        webView.loadUrl("file:///android_asset/" + htmlFileName);
    }

    @Override
    public void onBackPressed() {
        // Check if WebView is visible
        if (webView.getVisibility() == View.VISIBLE) {
            // Hide WebView and show the layout with TextViews
            webView.setVisibility(View.GONE);
            setContentView(R.layout.activity_immunization_knowledge);

            // Set OnClickListener for all TextViews again
            TextView[] textViews = {
                    findViewById(R.id.immunizationTextView),
                    findViewById(R.id.immunizationTableTextView),
                    findViewById(R.id.tetanusTextView),
                    findViewById(R.id.bcgTextView),
                    findViewById(R.id.hepatitisTextView),
                    findViewById(R.id.polioTextView),
                    findViewById(R.id.dptTextView),
                    findViewById(R.id.pentavalentTextView),
                    findViewById(R.id.rotavirusTextView),
                    findViewById(R.id.measlesRubellaTextView),
                    findViewById(R.id.vitaminATextView),
                    findViewById(R.id.vaccinesSensitiveTextView),
                    findViewById(R.id.importanceThingsTextView),
                    findViewById(R.id.childMilestoneTextView)
            };
            // Set OnClickListener for all TextViews
            for (TextView textView : textViews) {
                textView.setOnClickListener(this);
            }
        } else {
            super.onBackPressed();
        }
    }
}
