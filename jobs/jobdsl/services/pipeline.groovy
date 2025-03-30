import MyPipeline
import javaposse.jobdsl.dsl.DslFactory

deliveryPipelineView("My Application Pipeline") {
    pipelineInstances(5)
    showAggregatedPipeline()
    columns(1)
    updateInterval(60)
    enableManualTriggers()
    showAvatars()
    showChangeLog()
    pipelines {
        component("My Application", new MyPipeline(this as DslFactory).build.getName())
    }
} 