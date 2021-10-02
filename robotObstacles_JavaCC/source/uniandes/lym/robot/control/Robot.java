/* Generated By:JavaCC: Do not edit this line. Robot.java */
package uniandes.lym.robot.control;
import uniandes.lym.robot.kernel.*;
import java.awt.Point;
import java.io.*;
import java.util.Vector;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
@ SuppressWarnings("serial")
public class Robot implements RobotConstants {
  private RobotWorldDec world;
  private HashMap<String,Integer> variables = new HashMap<String,Integer>();
  private ArrayList<String> functions = new ArrayList<String>();
  private ArrayList<HashMap<String,Integer>> funcParam = new ArrayList<HashMap<String,Integer>>();
  private ArrayList<String> parameters = null;
  private String salida = new String();
  private ArrayList<String> rep = new ArrayList<String>();
  private HashMap<String,ArrayList<String>> functionDefine = new HashMap<String,ArrayList<String>>();
  private boolean isRep = false;
  private boolean noExec = false;
  void setWorld(RobotWorld w)
  {
    world = (RobotWorldDec) w;
  }
  void execute(String[] l) {
          switch (l[0]) {
        case "turnRight":
                        world.turnRight();
                break;
        case "moveForward":
                world.moveForward(Integer.parseInt(l[1]));
        break;
        case "putChip":
                world.putChip();
        break;
        case "putBalloon":
                world.putBalloon();
        break;
        case "pickupChip":
                world.pickupChip();
        break;
        case "popBalloon":
                world.popBalloon();
        break;
        case "countBalloons":
                world.countBalloons();
        break;
        case "chipExists":
                world.chipExists();
        break;
                case "isBLocked":
                String x = l[1].split("\u005c\u005c.")[0];
                String y = l[2].split("\u005c\u005c.")[0];
                world.chipExists(new Point(Integer.parseInt(x),Integer.parseInt(y)));
        break;
        default:
                break;
        }
}

  final public boolean command(StringBuffer sistema) throws ParseException {
  int x;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case T_MOVE:
      case T_RIGHT:
      case T_LEFT:
      case T_ROTATE:
      case T_LOOK:
      case T_DROP:
      case T_FREE:
      case T_PICK:
      case T_POP:
      case T_CHECK:
      case T_NOP:
      case T_REPEAT:
      case T_IF:
      case T_DEFINE:
      case T_TO:
      case NAME:
      case 32:
      case 33:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      commands();
    }
   System.out.println(salida);
   sistema.append(salida);
   {if (true) return false;}
    throw new Error("Missing return statement in function");
  }

/*
/Metodo que chequea todos los posibles comandos que se pueden ejecutar
*/
  final public void commands() throws ParseException, Error {
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case T_MOVE:
        move();
        break;
      case T_RIGHT:
        right();
        break;
      case T_LEFT:
        left();
        break;
      case T_ROTATE:
        rotate();
        break;
      case T_LOOK:
        look();
        break;
      case T_DROP:
        drop();
        break;
      case T_FREE:
        free();
        break;
      case T_PICK:
        pick();
        break;
      case T_POP:
        pop();
        break;
      case T_CHECK:
        check();
        break;
      case 33:
        block();
        break;
      case T_REPEAT:
        repeat();
        break;
      case T_IF:
        ifs();
        break;
      case T_DEFINE:
        define();
        break;
      case T_TO:
        function();
        break;
      case NAME:
        callFunction();
        break;
      case T_NOP:
        jj_consume_token(T_NOP);
        break;
      case 32:
        jj_consume_token(32);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case T_MOVE:
      case T_RIGHT:
      case T_LEFT:
      case T_ROTATE:
      case T_LOOK:
      case T_DROP:
      case T_FREE:
      case T_PICK:
      case T_POP:
      case T_CHECK:
      case T_NOP:
      case T_REPEAT:
      case T_IF:
      case T_DEFINE:
      case T_TO:
      case NAME:
      case 32:
      case 33:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
    }
  }

/**
*  reconoce un numero entero sin signo
* @return el valor entero correspondiente al valor reconocido
*/
  final public int numero() throws ParseException, Error {
  int total = 1;
    jj_consume_token(NUMERO);
    try
    {
      total = Integer.parseInt(token.image);
    }
    catch (NumberFormatException ee)
    {
      // Dada la forma de NUMERO, sabemos que solo puede tener d�gitos
      // Por lo tanto, lo unico que podria pasar es que el numero sea muy grande
      {if (true) throw new Error("Number out of bounds: " + token.image + "!!");}
    }
    {if (true) return total;}
    throw new Error("Missing return statement in function");
  }

/*
/Metodo que define la funcion Move
*/
  final public void move() throws ParseException, Error {
  int val = 0;
  boolean func = parameters!=null;
    jj_consume_token(T_MOVE);
    val = numOrVar();
    if (!noExec)
    {
      world.moveForward(val);
      salida = "comando moveForward";
      if (isRep)
        rep.add("moveForward_" + val);
    }
    if (func)
    {
      ArrayList<String> found = functionDefine.get(functions.get(functions.size() - 1));
      found.add("moveForward_" + val);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion Right
*/
  final public void right() throws ParseException, Error {
  int val = 0;
  boolean func = parameters!=null;
    jj_consume_token(T_RIGHT);
    val = numOrVar();
    if (!(val % 360 == 0))
    {
      if (val % 90 == 0)
      {
        if (val > 360)
        {
          while (val > 360)
          {
            val -= 360;
          }
        }
        while (val > 0)
        {
          val -= 90;
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
        }
        salida = "comando turnRight";
      }
      else
        {if (true) throw new Error("The value is not a multiple of 90");}
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion Left
*/
  final public void left() throws ParseException, Error {
   int val = 0;
   boolean func = parameters!=null;
    jj_consume_token(T_LEFT);
    val = numOrVar();
    if (!(val % 360 == 0))
    {
      if (val % 90 == 0)
      {
        if (val > 360)
        {
          while (val > 360)
          {
            val -= 360;
          }
        }
        if (val == 90) val = 270;
        else if (val == 270) val = 90;
        while (val > 0)
        {
          val -= 90;
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
        }
        salida = "comando turnLeft";
      }
      else
        {if (true) throw new Error("The value is not a multiple of 90");}
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion Rotate
*/
  final public void rotate() throws ParseException, Error {
  int val = 0;
  boolean func = parameters!=null;
    jj_consume_token(T_ROTATE);
    val = numOrVar();
    Random rand = new Random();
    int r = rand.nextInt(2);
    if (r >= 1)
    {
      {
        if (!(val % 360 == 0))
        {
          if (val % 90 == 0)
          {
            if (val > 360)
            {
              while (val > 360)
              {
                val -= 360;
              }
            }
            while (val > 0)
            {
              val -= 90;
              if (!noExec)
                world.turnRight();
              if (isRep)
                rep.add("turnRight");
              if (func)
              {
                ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
                found.add("turnRight");
              }
            }
            salida = "comando turnRight";
          }
          else
                {if (true) throw new Error("The value is not a multiple of 90");}
        }
      }
    }
    else
    {
      {
        if (!(val % 360 == 0))
        {
          if (val % 90 == 0)
          {
            if (val > 360)
            {
              while (val > 360)
              {
                val -= 360;
              }
            }
            if (val == 90) val = 270;
            else if (val == 270) val = 90;
            while (val > 0)
            {
              if (!noExec)
                world.turnRight();
              if (isRep)
                rep.add("turnRight");
              if (func)
              {
                ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
                found.add("turnRight");
              }
              val -= 90;
            }
            salida = "comando turnLeft";
          }
          else
                {if (true) throw new Error("The value is not a multiple of 90");}
        }
      }
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion Look
*/
  final public void look() throws ParseException {
  String x;
  int val = 0;
  boolean func = parameters!=null;
    jj_consume_token(T_LOOK);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case T_NORTH:
      jj_consume_token(T_NORTH);
      break;
    case T_EAST:
      jj_consume_token(T_EAST);
      break;
    case T_WEST:
      jj_consume_token(T_WEST);
      break;
    case T_SOUTH:
      jj_consume_token(T_SOUTH);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    x = token.image;
    if (x.equals("N"))
    {
      if (world.facingEast())
      {
        val = 270;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      else if (world.facingWest())
      {
        val = 90;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      else if (world.facingSouth())
      {
        val = 180;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      salida = "Se esta mirando al norte";
    }
    else if (x.equals("S"))
    {
      if (world.facingEast())
      {
        val = 90;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 270;
        }
      }
      else if (world.facingWest())
      {
        val = 270;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      else if (world.facingNorth())
      {
        val = 180;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      salida = "Se esta mirando al sur";
    }
    else if (x.equals("E"))
    {
      if (world.facingNorth())
      {
        val = 90;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      else if (world.facingWest())
      {
        val = 180;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      else if (world.facingSouth())
      {
        val = 270;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      salida = "Se esta mirando al este";
    }
    else if (x.equals("W"))
    {
      if (world.facingEast())
      {
        val = 180;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      else if (world.facingNorth())
      {
        val = 270;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      else if (world.facingSouth())
      {
        val = 90;
        while (val > 0)
        {
          if (!noExec)
                world.turnRight();
          if (isRep)
                rep.add("turnRight");
          if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("turnRight");
          }
          val -= 90;
        }
      }
      salida = "Se esta mirando al oeste(west)";
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion Drop
*/
  final public void drop() throws ParseException, Error {
  int val = 0;
  boolean func = parameters!=null;
    jj_consume_token(T_DROP);
    val = numOrVar();
    for (int i = 0; val > i; i++)
    {
      if (!noExec)
        world.putChip();
      if (isRep)
        rep.add("putChip");
      if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("putChip");
          }
    }
    salida = "comando DROP";
  }

/*
/Metodo que define la funcion Free
*/
  final public void free() throws ParseException, Error {
  int val = 0;
  boolean func = parameters!=null;
    jj_consume_token(T_FREE);
    val = numOrVar();
    for (int i = 0; val > i; i++)
    {
      if (!noExec)
        world.putBalloon();
      if (isRep)
        rep.add("putBalloon");
      if (func)
          {
            ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
            found.add("putBalloon");
          }
    }
    salida = "comando FREE";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion Pick
*/
  final public void pick() throws ParseException, Error {
 int val = 0;
 boolean func = parameters!=null;
    jj_consume_token(T_PICK);
    val = numOrVar();
    {
      for (int i = 0; val > i; i++)
      {
        if (!noExec)
                world.pickupChip();
        if (isRep)
                rep.add("pickupChip");
        if (func)
        {
          ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
          found.add("pickupChip");
        }
      }
      salida = "comando PICK";
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion Pop
*/
  final public void pop() throws ParseException, Error {
  int val = 0;
  boolean func = parameters!=null;
    jj_consume_token(T_POP);
    val = numOrVar();
    {
      for (int i = 0; val > i; i++)
      if (!noExec)
        world.popBalloon();
      if (isRep)
        rep.add("popBalloon");
      if (func)
      {
        ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
        found.add("popBalloon");
      }
      salida = "comando POP";
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion Check
*/
  final public void check() throws ParseException, Error {
        int val = 0;
        String x  = "";
        boolean func = parameters!=null;
    jj_consume_token(T_CHECK);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case T_CHIPS:
      jj_consume_token(T_CHIPS);
      break;
    case T_BALLOONS:
      jj_consume_token(T_BALLOONS);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    x = token.image;
    val = numOrVar();
    if (x.equals("B"))
    {
      int aux = world.countBalloons();
      if (isRep)
        rep.add("countBalloons");
      if (func)
      {
        ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
        found.add("countBalloons");
      }
      if (aux == val)
        salida = "Hay " + val + " globos\u005cn";
      else
        salida = "No hay " + val + " globos\u005cn";
    }
    else
    {
      boolean aux = world.chipExists();
      if (isRep)
        rep.add("chipExists");
      if (func)
      {
        ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
        found.add("chipExists");
      }
      if (aux && val == 1)
        salida = "Hay " + val + " fichas\u005cn";
      else
        salida = "No hay " + val + " fichas\u005cn";
    }
    if (noExec)
        salida = "\u005cn";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public boolean blockedDP() throws ParseException {
  Point val;
  boolean func = parameters!=null;
    jj_consume_token(T_BLOCKEDP);
    val = world.getPosition();
    int x = (int) val.getX();
    int y = (int) val.getY();
    switch (world.getFacing())
    {
      case 0 :
      x += 1;
      break;
      case 1 :
      x -= 1;
      break;
      case 2 :
      y += 1;
      break;
      case 3 :
      y -= 1;
      break;
      default :
      break;
    }
    val = new Point(x, y);
    boolean z = world.isBlocked(val);
    if (isRep)
        rep.add("isBlocked_" + val.getX() + "_" + val.getY());
    if (func)
    {
      ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
      found.add("isBlocked_" + val.getX() + "_" + val.getY());
    }
    salida = (z) ? "El robot se encuentra bloqueado" : salida;
    if (noExec)
        salida = "";
    {if (true) return z;}
    throw new Error("Missing return statement in function");
  }

/*
/Metodo que define Block
*/
  final public void block() throws ParseException {
    jj_consume_token(33);
    jj_consume_token(T_BLOCK);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    commands();
    jj_consume_token(34);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion Repeat
*/
  final public void repeat() throws ParseException {
  int val = 0;
  boolean func = parameters!=null;
    jj_consume_token(T_REPEAT);
    val = numOrVar();
    jj_consume_token(35);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    default:
      jj_la1[16] = jj_gen;
      ;
    }
    isRep = true;
    salida = "funciona";
    commands();
    for (int j = 1; j < val; j++)
    {
      for (int i = 0; i < rep.size(); i++)
      {
        if (func)
    {
      ArrayList < String > found = functionDefine.get(functions.get(functions.size() - 1));
      found.add(rep.get(i));
    }
        String [ ] iter = rep.get(i).split("_");
        execute(iter);
      }
    }
    isRep = false;
    rep.clear();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    default:
      jj_la1[17] = jj_gen;
      ;
    }
    jj_consume_token(36);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion IF (cambie el nombre porque estaba sobreescribiendo el metodo if como tal)
*/
  final public void ifs() throws ParseException, Error {
  boolean val = false;
  int neg = 0;
    jj_consume_token(T_IF);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 37:
        ;
        break;
      default:
        jj_la1[19] = jj_gen;
        break label_3;
      }
      jj_consume_token(37);
                 neg++;
    }
    val = blockedDP();
    jj_consume_token(35);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    default:
      jj_la1[20] = jj_gen;
      ;
    }
     for(int i=0;neg>i;i++)
         val = !(val);
         if(val==false)
                  noExec = true;
    commands();
          noExec = false;
         salida = ""+val;
    jj_consume_token(36);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
  }

/*
/Metodo que define la funcion DEFINE
/Se revisa que la funcion no haya sido declarada previamente
*/
  final public void define() throws ParseException, Error {
  String nombre = "";
  boolean func = parameters!=null;
    if (func)
        {if (true) throw new Error("Can't define variable inside a TO instruction");}
    jj_consume_token(T_DEFINE);
    jj_consume_token(NAME);
    nombre = token.image;
    if (variables.containsKey(nombre))
    {
      {if (true) throw new Error("The variable is already defined");}
    }
    numero();
    variables.put(nombre, Integer.parseInt(token.image));
    salida = "Se definio correctamente la variable";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
/Metodo que define la funcion TO
*/
  final public void function() throws ParseException, Error {
  Token x;
  Token y;
  int numParams = 0;
  boolean func = parameters!=null;
    if ( func ) {
      parameters = null;
        {if (true) throw new Error("Can't create a function inside another function");}
   }
    noExec = true;
    parameters = new ArrayList<String>();
    jj_consume_token(T_TO);
    x = jj_consume_token(NAME);
    //Revisar si ya se declaro anteriormente esta variable
        if(variables.containsKey(x)||functions.contains(x))
                {if (true) throw new Error("The function is already defined");}
    functions.add(x.image);
    funcParam.add(new HashMap<String,Integer>());
    functionDefine.put(x.image, new ArrayList<String>());
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 38:
        ;
        break;
      default:
        jj_la1[23] = jj_gen;
        break label_4;
      }
      jj_consume_token(38);
      y = jj_consume_token(NAME);
                //Revisar si ya se declaro anteriormente esta variable
                if(variables.containsKey(y)||functions.contains(y))
                        {if (true) throw new Error("The parameter is already defined");}
        parameters.add(y.image);
        funcParam.get(functions.indexOf(x.image)).put(y.image,0);
        numParams++;
    }
    jj_consume_token(32);
    jj_consume_token(T_OUTPUT);
    commands();
    jj_consume_token(T_END);
    parameters = null;
    noExec = false;
  }

/*
/Metodo que llama a una funcion existente
*/
  final public void callFunction() throws ParseException {
  Token x;
  int numParameters;
  boolean func = parameters!=null;
    x = jj_consume_token(NAME);
    if (!functions.contains(Integer.parseInt(x.image))) {
      {if (true) throw new Error("The function isn't defined");}
    }
    else {
      numParameters = funcParam.get(functions.indexOf(x.image)).size();
    }
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMERO:
      case NAME:
      case 38:
        ;
        break;
      default:
        jj_la1[24] = jj_gen;
        break label_5;
      }
      numOrVar();
                  numParameters--;
    }
      if (numParameters != 0) {
        {if (true) throw new Error("The function call doesn't contain the right ammount of parameters");}
      }
  }

/*
/Metodo que evalua si un parametro es una variable existente o un entero
/Se utiliza el metodo numero() para comprobar si es un entero y se revisa la lista de variables para verificar si ya existe la variable
*/
  final public int numOrVar() throws ParseException, Error {
  Token x;
  boolean func = parameters!=null;
  boolean isParam = false;
  int val = 0;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMERO:
      val = numero();
        {if (true) return val;}
      break;
    case NAME:
    case 38:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 38:
        jj_consume_token(38);
           isParam = true;
                        if ( !func ) {
                          {if (true) throw new Error("Can't use parameters if not inside function");}
                          }
        break;
      default:
        jj_la1[25] = jj_gen;
        ;
      }
      x = jj_consume_token(NAME);
    if (!variables.containsKey(x.image)) {
      if ( isParam ) {
              if ( !parameters.contains(x.image)) {
                {if (true) throw new Error("The variable " + x.image + " is not defined in the parameters of the function");}
              }
          } else {
        {if (true) throw new Error("The variable " + x.image + " is not defined");}
      }
     }
     {if (true) return variables.get(x.image);}
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public RobotTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[27];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x801ebff0,0x801ebff0,0x801ebff0,0x1,0x1,0x1,0x1,0x1e000000,0x1,0x1,0x1,0x1,0x1800000,0x1,0x0,0x1,0x0,0x0,0x1,0x0,0x0,0x0,0x1,0x0,0xa0000000,0x0,0xa0000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x3,0x3,0x3,0x1,0x1,0x1,0x1,0x0,0x1,0x1,0x1,0x1,0x0,0x1,0x1,0x1,0x1,0x1,0x1,0x20,0x1,0x1,0x1,0x40,0x40,0x40,0x40,};
   }

  /** Constructor with InputStream. */
  public Robot(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Robot(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new RobotTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Robot(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new RobotTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Robot(RobotTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(RobotTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[39];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 27; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 39; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
