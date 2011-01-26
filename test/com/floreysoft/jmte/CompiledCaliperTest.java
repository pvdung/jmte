package com.floreysoft.jmte;

import com.floreysoft.jmte.sample.SampleIfEmptyFalseExpressionCompiledTemplate;
import com.floreysoft.jmte.sample.SampleNewlineForeachSeparatorCompiledTemplate;
import com.floreysoft.jmte.sample.SampleSimpleExpressionCompiledTemplate;
import com.google.caliper.SimpleBenchmark;

public class CompiledCaliperTest {

	/**
	 * Tests a selection of scripts supposed to be the most frequently used
	 * 
	 * @author olli
	 * 
	 */
	public static class PortfolioBenchmark extends SimpleBenchmark {
		InterpretedEngineTest engineTest = new InterpretedEngineTest();
		Engine cachingEngine = new Engine();
		{
			cachingEngine.setEnabledInterpretedTemplateCache(true);
		}
		CompiledEngineTest compiledEngineTest = new CompiledEngineTest();

		public void timeSimpleExpressionReference(int reps) throws Exception {
			Engine engine = engineTest.newEngine();
			engine.setEnabledInterpretedTemplateCache(false);
			for (int i = 0; i < reps; i++) {
				engine.transform("${address}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timeSimpleExpressionCached(int reps) throws Exception {
			Engine engine = cachingEngine;
			for (int i = 0; i < reps; i++) {
				engine.transform("${address}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timeSimpleExpressionCompiled(int reps) throws Exception {
			Engine engine = compiledEngineTest.newEngine();
			for (int i = 0; i < reps; i++) {
				engine.transform("${address}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timePrototypeCompiledSimpleExpression(int reps)
				throws Exception {
			SampleSimpleExpressionCompiledTemplate template = new SampleSimpleExpressionCompiledTemplate(new Engine());
			for (int i = 0; i < reps; i++) {
				template
						.transform(InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timeComplexExpressionReference(int reps) throws Exception {
			Engine engine = engineTest.newEngine();
			engine.setEnabledInterpretedTemplateCache(false);
			for (int i = 0; i < reps; i++) {
				engine.transform("${<h1>,address(NIX),</h1>;long(full)}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timeComplexExpressionCached(int reps) throws Exception {
			Engine engine = cachingEngine;
			for (int i = 0; i < reps; i++) {
				engine.transform("${<h1>,address(NIX),</h1>;long(full)}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timeComplexExpressionCompiled(int reps) throws Exception {
			Engine engine = compiledEngineTest.newEngine();
			for (int i = 0; i < reps; i++) {
				engine.transform("${<h1>,address(NIX),</h1>;long(full)}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timePrototypeCompiledComplexExpression(int reps)
				throws Exception {
			SampleSimpleExpressionCompiledTemplate template = new SampleSimpleExpressionCompiledTemplate(new Engine());
			for (int i = 0; i < reps; i++) {
				template
						.transform(InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timeIf(int reps) throws Exception {
			Engine engine = engineTest.newEngine();
			engine.setEnabledInterpretedTemplateCache(false);
			for (int i = 0; i < reps; i++) {
				engine.transform("${if empty}${address}${else}NIX${end}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}


		public void timeIfCached(int reps) throws Exception {
			Engine engine = cachingEngine;
			for (int i = 0; i < reps; i++) {
				engine.transform("${if empty}${address}${else}NIX${end}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timeIfCompiled(int reps) throws Exception {
			Engine engine = compiledEngineTest.newEngine();
			for (int i = 0; i < reps; i++) {
				engine.transform("${if empty}${address}${else}NIX${end}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timePrototypeCompiledIfExpression(int reps)
				throws Exception {
			SampleIfEmptyFalseExpressionCompiledTemplate template = new SampleIfEmptyFalseExpressionCompiledTemplate(new Engine());
			for (int i = 0; i < reps; i++) {
				template
						.transform(InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timeForeach(int reps) throws Exception {
			Engine engine = engineTest.newEngine();
			engine.setEnabledInterpretedTemplateCache(false);
			for (int i = 0; i < reps; i++) {
				engine.transform(
						"${ foreach list item \n}${item.property1}${end}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timeForeachCached(int reps) throws Exception {
			Engine engine = cachingEngine;
			for (int i = 0; i < reps; i++) {
				engine.transform(
						"${ foreach list item \n}${item.property1}${end}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timeForeachCompiled(int reps) throws Exception {
			Engine engine = compiledEngineTest.newEngine();
			for (int i = 0; i < reps; i++) {
				engine.transform(
						"${ foreach list item \n}${item.property1}${end}",
						InterpretedEngineTest.DEFAULT_MODEL);
			}
		}

		public void timePrototypeCompiledForeachExpression(int reps)
				throws Exception {
			SampleNewlineForeachSeparatorCompiledTemplate template = new SampleNewlineForeachSeparatorCompiledTemplate(new Engine());
			for (int i = 0; i < reps; i++) {
				template
						.transform(InterpretedEngineTest.DEFAULT_MODEL);
			}
		}
	}

}