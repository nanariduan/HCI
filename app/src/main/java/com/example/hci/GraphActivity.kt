package com.example.hci

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.GraphBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.io.FileNotFoundException
import java.util.*

class GraphActivity :AppCompatActivity(){
    private lateinit var binding: GraphBinding
    lateinit var chartWeek:BarChart
    var xdata: IntArray = intArrayOf(0,0,0,0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout for this fragment
        initData()

        binding =GraphBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setChartView()

    }


private fun setChartView() {
    chartWeek = binding.root.findViewById<BarChart>(R.id.chart_week)
    setWeek(chartWeek)
}

    private fun initData():IntArray{

        try {
            xdata[0] = readFileScan("breakfast.txt")
        }catch (e: FileNotFoundException){
            xdata[0] = 0
        }
        try{
            xdata[1] = readFileScan("lunch.txt")
        }catch (e: FileNotFoundException){
            xdata[1] = 0
        }
        try{
            xdata[2] = readFileScan("dinner.txt")
        }catch (e: FileNotFoundException){
            xdata[2] = 0
        }
        try{
            xdata[3] = readFileScan("snack.txt")
        }catch (e: FileNotFoundException){
            xdata[3] = 0
        }
        return xdata
    }

    private fun initBarDataSet(barDataSet: BarDataSet) {
        //Changing the color of the bar
        barDataSet.color = Color.parseColor("#304567")
        //Setting the size of the form in the legend
        barDataSet.formSize = 15f
        //showing the value of the bar, default true if not set
        barDataSet.setDrawValues(false)
        //setting the text size of the value of the bar
        barDataSet.valueTextSize = 12f
    }

    private fun setWeek(barChart: BarChart) {
        initBarChart(barChart)

        barChart.setScaleEnabled(false) //Zoom In/Out

        val valueList = java.util.ArrayList<Double>()
        val entries: java.util.ArrayList<BarEntry> = java.util.ArrayList()
        val title = "Calorie Data"

        //input data
        for (i in 0..3) {
            valueList.add(xdata[i].toDouble())
        }

        //fit the data into a bar
        for (i in 0 until valueList.size) {
            val barEntry = BarEntry(i.toFloat(), valueList[i].toFloat())
            entries.add(barEntry)
        }
        val barDataSet = BarDataSet(entries, title)
        barDataSet.setColors(Color.RED,resources.getColor(R.color.baroren),
            Color.YELLOW,Color.GREEN)
        val data = BarData(barDataSet)
        barChart.data = data
        barChart.invalidate()
    }

    private fun initBarChart(barChart: BarChart) {
        //hiding the grey background of the chart, default false if not set
        barChart.setDrawGridBackground(false)
        //remove the bar shadow, default false if not set
        barChart.setDrawBarShadow(false)
        //remove border of the chart, default false if not set
        barChart.setDrawBorders(false)

        //remove the description label text located at the lower right corner
        val description = Description()
        description.setEnabled(false)
        barChart.setDescription(description)

        //X, Y 바의 애니메이션 효과
        barChart.animateY(1000)
        barChart.animateX(1000)

        val total = xdata[0] + xdata[1] + xdata[2] + xdata[3]
        val totaltext = findViewById<TextView>(R.id.totaltxt)
        totaltext.setText(total.toString()+" KCAL")


        //바텀 좌표 값
        val xAxis: XAxis = barChart.getXAxis()
        val xAxisLabels = listOf("breakfast","lunch","dinner","snack")
        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
        //change the position of x-axis to the bottom
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        //set the horizontal distance of the grid line
        xAxis.granularity = 1f
        xAxis.textColor = Color.BLACK
        //hiding the x-axis line, default true if not set
        xAxis.setDrawAxisLine(false)
        //hiding the vertical grid lines, default true if not set
        xAxis.setDrawGridLines(false)

        //좌측 값 hiding the left y-axis line, default true if not set
//        val leftAxis: YAxis = barChart.getAxisLeft()
//        leftAxis.setDrawAxisLine(false)
//        leftAxis.textColor = Color.RED

        //우측 값 hiding the right y-axis line, default true if not set
        val rightAxis: YAxis = barChart.getAxisRight()
        rightAxis.setDrawAxisLine(false)
        rightAxis.textColor = Color.BLACK

        //바차트의 타이틀
        val legend: Legend = barChart.getLegend()
        //setting the shape of the legend form to line, default square shape
        legend.form = Legend.LegendForm.LINE
        //setting the text size of the legend
        legend.textSize = 11f
        legend.textColor = Color.BLACK
        //setting the alignment of legend toward the chart
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        //setting the stacking direction of legend
        legend.orientation = Legend.LegendOrientation.HORIZONTAL
        //setting the location of legend outside the chart, default false if not set
        legend.setDrawInside(false)
    }

    fun readFileScan(filename: String): Int{
        val scan = Scanner(openFileInput(filename))
        var total = 0
        while (scan.hasNextLine()) {
            val name = scan.nextLine()
            val calorie = scan.nextLine().toInt()
            total += calorie
        }
        return total
    }
}