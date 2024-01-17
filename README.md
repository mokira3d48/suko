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

### Interpreteur
L'expression à calculer sera représentée sous forme arborescence, dans un premier temps. C'est ce
arbre de calcul qui sera évalué pour obtenir le résultat final. Danc, dans ce arbre de calcul,
les branches représentent les termes et les noeuds représentent les opérations.

<div align="center">
	<img src="./images/tree_calculus.png" width="60%" height="60%"/>
<p>

*Figure 01* : Exemple d'un arbre de calcul.

</p>
<br/>

</div>


<div align="center">
	<img src="./images/interpreter.png" width="90%" height="90%"/>
<p>

*Figure 02* : Diagramme des classes du modèle interpreteur.

</p>
<br/>

</div>


### Analyseur

<div align="center">
	<img src="./images/pipeline.png" width="90%" height="90%"/>
<p>

*Figure 03* : Pipeline de l'analyse et construction de l'abre de calcul.

</p>
<br/>

</div>


<div align="center">
	<img src="./images/analyser.png" width="90%" height="90%"/>
<p>

*Figure 04* : Diagramme des classes de l'analyseur.

</p>
<br/>

</div>

### Instance de calculatrice
Ici, il s'agira de "builder" une instance de la calculatrice (`Calculator`) muni de son analyseur.
Pour cela nous allons utiliser le pattern Builder pour élaboler le programme qui va nous permettre
de construire une instance de notre calculatrice.



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
