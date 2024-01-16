# Super Kalculator

<div align="center">

![](./images/suko_screenshot.png)

</div>

## Spécifications
Dans une expression, nous avons des opérations et des termes. Les différentes opérations possibles
que nous pouvons avoir sont des additions, multiplications, soustrations et divisions. Les termes
ne sont uniquement que des nombres entiers. Donc, il n'y aura aucune implémentation pour gérer
des nombres réels. Vooici un exemple d'expression :

$$
97 \times 985 + 109 - 229
$$

L'expression à calculer sera représentée sous forme arborescence, dans un premier temps. C'est ce
arbre de calcul qui sera évalué pour obtenir le résultat final. Danc, dans ce arbre de calcul,
les branches représentent les termes et les noeuds représentent les opérations.

<div align="center">

<img src="./images/tree_calculus.png" width="60%" height="60%"/>

</div>


## Implémentation

### Construction d'une calculatrice

```java
Builder<Calculator> b = new CalculatorBuilder();
Director director = new Director(b);
director.makeBuild();
Calculator calc = b.getResult();
```

### Définition du contexte

```java
// instantiate the context
Context ctx = new Context();

ctx.assign("alpha", 8);
ctx.assign("x1", 0);
ctx.assign("x2", 12);
ctx.assign("x3", 10);
ctx.assign("x4", 65);
ctx.assign("x5", 32);
ctx.assign("x6", 10);

```

### Expression à évaluer

```java
calc.setExpression("alpha + x2 * x3 - x4 * x4 + x4 * (x1 + alpha) + x5 / (x3 * x2)");
calc.setContext(ctx);

System.out.println(ctx);
System.out.println("Expression = " + calc.getExpression());
```

![](./images/output01.png)


### Evaluation de l'expression

```java

try {
	Double result = calc.evaluate();
	System.out.println("Result = " + result.intValue());
} catch (SemanticError e) {
	System.out.println("SemanticError: \t" + e);
} catch (Exception e) {
	e.printStackTrace();
}

```

![](./images/output02.png)
