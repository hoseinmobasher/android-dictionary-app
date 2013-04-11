package com.support.farsi;

import android.content.Context;
import android.graphics.Typeface;

public final class FarsiSupport {

	public static boolean isFarsiConversionNeeded = true;

	private final static String szLamAndAlef = Character
			.toString((char) 0xfedf) + Character.toString((char) 0xfe8e);

	private final static String szLamStickAndAlef = Character
			.toString((char) 0xfee0) + Character.toString((char) 0xfe8e);

	private final static String szLa = Character.toString((char) 0xfefb);
	private final static String szLaStick = Character.toString((char) 0xfefc);

	private static final class struc {
		public char character;
		public char endGlyph;
		public char iniGlyph;
		public char midGlyph;
		public char isoGlyph;

		public struc(char Character, char EndGlyph, char IniGlyph,
				char MidGlyph, char IsoGlyph) {
			character = Character;
			endGlyph = EndGlyph;
			iniGlyph = IniGlyph;
			midGlyph = MidGlyph;
			isoGlyph = IsoGlyph;
		}
	}

	static struc[] arrStruc = {
			new struc((char) 0x630, (char) 0xfeac, (char) 0xfeab,
					(char) 0xfeac, (char) 0xfeab),
			new struc((char) 0x62f, (char) 0xfeaa, (char) 0xfea9,
					(char) 0xfeaa, (char) 0xfea9),
			new struc((char) 0x62c, (char) 0xfe9e, (char) 0xfe9f,
					(char) 0xfea0, (char) 0xfe9d),
			new struc((char) 0x62d, (char) 0xfea2, (char) 0xfea3,
					(char) 0xfea4, (char) 0xfea1),
			new struc((char) 0x62e, (char) 0xfea6, (char) 0xfea7,
					(char) 0xfea8, (char) 0xfea5),
			new struc((char) 0x647, (char) 0xfeea, (char) 0xfeeb,
					(char) 0xfeec, (char) 0xfee9),
			new struc((char) 0x639, (char) 0xfeca, (char) 0xfecb,
					(char) 0xfecc, (char) 0xfec9),
			new struc((char) 0x63a, (char) 0xfece, (char) 0xfecf,
					(char) 0xfed0, (char) 0xfecd),
			new struc((char) 0x641, (char) 0xfed2, (char) 0xfed3,
					(char) 0xfed4, (char) 0xfed1),
			new struc((char) 0x642, (char) 0xfed6, (char) 0xfed7,
					(char) 0xfed8, (char) 0xfed5),
			new struc((char) 0x62b, (char) 0xfe9a, (char) 0xfe9b,
					(char) 0xfe9c, (char) 0xfe99),
			new struc((char) 0x635, (char) 0xfeba, (char) 0xfebb,
					(char) 0xfebc, (char) 0xfeb9),
			new struc((char) 0x636, (char) 0xfebe, (char) 0xfebf,
					(char) 0xfec0, (char) 0xfebd),
			new struc((char) 0x637, (char) 0xfec2, (char) 0xfec3,
					(char) 0xfec4, (char) 0xfec1),
			new struc((char) 0x643, (char) 0xfeda, (char) 0xfedb,
					(char) 0xfedc, (char) 0xfed9),
			new struc((char) 0x645, (char) 0xfee2, (char) 0xfee3,
					(char) 0xfee4, (char) 0xfee1),
			new struc((char) 0x646, (char) 0xfee6, (char) 0xfee7,
					(char) 0xfee8, (char) 0xfee5),
			new struc((char) 0x62a, (char) 0xfe96, (char) 0xfe97,
					(char) 0xfe98, (char) 0xfe95),
			new struc((char) 0x627, (char) 0xfe8e, (char) 0xfe8d,
					(char) 0xfe8e, (char) 0xfe8d),
			new struc((char) 0x644, (char) 0xfede, (char) 0xfedf,
					(char) 0xfee0, (char) 0xfedd),
			new struc((char) 0x628, (char) 0xfe90, (char) 0xfe91,
					(char) 0xfe92, (char) 0xfe8f),
			new struc((char) 0x64a, (char) 0xfef2, (char) 0xfef3,
					(char) 0xfef4, (char) 0xfef1),
			new struc((char) 0x633, (char) 0xfeb2, (char) 0xfeb3,
					(char) 0xfeb4, (char) 0xfeb1),
			new struc((char) 0x634, (char) 0xfeb6, (char) 0xfeb7,
					(char) 0xfeb8, (char) 0xfeb5),
			new struc((char) 0x638, (char) 0xfec6, (char) 0xfec7,
					(char) 0xfec8, (char) 0xfec5),
			new struc((char) 0x632, (char) 0xfeb0, (char) 0xfeaf,
					(char) 0xfeb0, (char) 0xfeaf),
			new struc((char) 0x648, (char) 0xfeee, (char) 0xfeed,
					(char) 0xfeee, (char) 0xfeed),
			new struc((char) 0x629, (char) 0xfe94, (char) 0xfe93,
					(char) 0xfe93, (char) 0xfe93),
			new struc((char) 0x649, (char) 0xfef0, (char) 0xfeef,
					(char) 0xfef0, (char) 0xfeef),
			new struc((char) 0x631, (char) 0xfeae, (char) 0xfead,
					(char) 0xfeae, (char) 0xfead),
			new struc((char) 0x624, (char) 0xfe86, (char) 0xfe85,
					(char) 0xfe86, (char) 0xfe85),
			new struc((char) 0x621, (char) 0xfe80, (char) 0xfe80,
					(char) 0xfe80, (char) 0xfe80),
			new struc((char) 0x626, (char) 0xfe8a, (char) 0xfe8b,
					(char) 0xfe8c, (char) 0xfe89),
			new struc((char) 0x623, (char) 0xfe84, (char) 0xfe83,
					(char) 0xfe84, (char) 0xfe83),
			new struc((char) 0x622, (char) 0xfe82, (char) 0xfe81,
					(char) 0xfe82, (char) 0xfe81),
			new struc((char) 0x625, (char) 0xfe88, (char) 0xfe87,
					(char) 0xfe88, (char) 0xfe87),
			new struc((char) 0x67e, (char) 0xfb57, (char) 0xfb58,
					(char) 0xfb59, (char) 0xfb56), // peh
			new struc((char) 0x686, (char) 0xfb7b, (char) 0xfb7c,
					(char) 0xfb7d, (char) 0xfb7a), // cheh
			new struc((char) 0x698, (char) 0xfb8b, (char) 0xfb8a,
					(char) 0xfb8b, (char) 0xfb8a), // jeh
			new struc((char) 0x6a9, (char) 0xfb8f, (char) 0xfb90,
					(char) 0xfb91, (char) 0xfb8e), // keheh
			new struc((char) 0x6af, (char) 0xfb93, (char) 0xfb94,
					(char) 0xfb95, (char) 0xfb92), // gaf
			new struc((char) 0x6cc, (char) 0xfbfd, (char) 0xfbfe,
					(char) 0xfbff, (char) 0xfbfc), // Farsi yeh
			new struc((char) 0x6cc, (char) 0xfbfd, (char) 0xfef3,
					(char) 0xfef4, (char) 0xfbfc), // Arabic yeh
			new struc((char) 0x6c0, (char) 0xfba5, (char) 0xfba4,
					(char) 0xfba5, (char) 0xfba4) // heh with yeh
	};

	private static final int N_DISTINCT_CHARACTERS = 43;

	private static final String ArabicReverse(String s) {
		try {
			String Out = "", rev;
			s = MakeReverse(s);
			char[] chs = new char[s.length()];
			chs = s.toCharArray();
			int i = 0;
			while (i < s.length()) {
				if ((chs[i] >= '0' && chs[i] <= '9')) {
					rev = "";
					while (i < s.length()
							&& ((chs[i] >= '0' && chs[i] <= '9') || chs[i] == '/')) {
						rev = rev + chs[i];
						++i;
					}
					rev = MakeReverse(rev);
					Out = Out + rev;
				} else {
					Out = Out + chs[i];
					++i;
				}
			}
			s = Out;
		} catch (Exception ex) {
		}
		return s;
	}

	private static final boolean isFromTheSet1(char ch) {
		char[] theSet1 = new char[] { (char) 0x62c, (char) 0x62d, (char) 0x62e,
				(char) 0x647, (char) 0x639, (char) 0x63a, (char) 0x641,
				(char) 0x642, (char) 0x62b, (char) 0x635, (char) 0x636,
				(char) 0x637, (char) 0x643, (char) 0x645, (char) 0x646,
				(char) 0x62a, (char) 0x644, (char) 0x628, (char) 0x64a,
				(char) 0x633, (char) 0x634, (char) 0x638, (char) 0x67e,
				(char) 0x686, (char) 0x6a9, (char) 0x6af, (char) 0x6cc,
				(char) 0x626 };
		int i = 0;
		while (i < 28) {
			if (ch == theSet1[i])
				return true;
			++i;
		}
		return false;
	}

	private static final boolean isFromTheSet2(char ch) {
		char[] theSet2 = new char[] { (char) 0x627, (char) 0x623, (char) 0x625,
				(char) 0x622, (char) 0x62f, (char) 0x630, (char) 0x631,
				(char) 0x632, (char) 0x648, (char) 0x624, (char) 0x629,
				(char) 0x649, (char) 0x698, (char) 0x6c0 };
		int i = 0;
		while (i < 14) {
			if (ch == theSet2[i])
				return true;
			++i;
		}
		return false;
	}

	private static final String MakeReverse(String text) {
		String Result = "";
		char[] Ctext = new char[text.length()];
		Ctext = text.toCharArray();
		for (int i = (text.length()) - 1; i >= 0; i--) {
			Result += Ctext[i];
		}
		return Result;
	}

	public static final String ConvertToRealFarsi(String In) {
		String strOut = "";
		StringBuilder strBuilder = new StringBuilder("");
		int i = 0;
		int j = 0;
		char[] chIn = new char[In.length()];
		chIn = In.toCharArray();

		for (i = 0; i < In.length(); i++) {
			boolean found = false;
			for (j = 0; j < arrStruc.length; j++) {
				if (chIn[i] == arrStruc[j].midGlyph
						|| chIn[i] == arrStruc[j].iniGlyph
						|| chIn[i] == arrStruc[j].endGlyph
						|| chIn[i] == arrStruc[j].isoGlyph) {
					strBuilder.append(arrStruc[j].character);
					found = true;
					break;
				}
			}
			if (!found)
				strBuilder.append(chIn[i]);
		}

		strOut = strBuilder.toString();
		strOut = strOut.replace(szLa, "لا");
		strOut = strOut.replace(szLaStick, "لا");

		return strOut;
	}

	public static final String ConvertForDrawOnBitmap(String In) {
		return ArabicReverse(Convert(In));
	}

	public static final String Convert(String In) {

		if (!isFarsiConversionNeeded) {
			return In;
		}

		try {

			boolean linkBefore, linkAfter;
			String Out = In;
			char[] chOut = new char[Out.length()];
			chOut = Out.toCharArray();
			char[] chIn = new char[In.length()];
			chIn = In.toCharArray();

			for (int i = 0; i < In.length(); i++) {
				/* WCHAR */
				char ch = chIn[i];
				if ((ch >= (char) 0x0621 && ch <= (char) 0x064a)
						|| (ch == (char) 0x067e) || (ch == (char) 0x0686)
						|| (ch == (char) 0x0698) || (ch == (char) 0x06a9)
						|| (ch == (char) 0x06af) || (ch == (char) 0x06cc)
						|| (ch == (char) 0x06c0)) // is an Arabic character?
				{
					int idx = 0;
					while (idx < N_DISTINCT_CHARACTERS) {
						if (arrStruc[idx].character == chIn[i])
							break;
						++idx;
					}

					if (i == In.length() - 1)
						linkAfter = false;
					else
						linkAfter = (isFromTheSet1(chIn[i + 1]) || isFromTheSet2(chIn[i + 1]));
					if (i == 0)
						linkBefore = false;
					else
						linkBefore = isFromTheSet1(chIn[i - 1]);
					if (idx < N_DISTINCT_CHARACTERS) {
						if (linkBefore && linkAfter)
							chOut[i] = arrStruc[idx].midGlyph;
						if (linkBefore && !linkAfter)
							chOut[i] = arrStruc[idx].endGlyph;
						if (!linkBefore && linkAfter)
							chOut[i] = arrStruc[idx].iniGlyph;
						if (!linkBefore && !linkAfter)
							chOut[i] = arrStruc[idx].isoGlyph;
					} else {
						chOut[i] = chIn[i];
					}
				} else {
					chOut[i] = chIn[i];
				}
			}
			Out = "";
			for (int j = 0; j < chOut.length; j++)
				Out += chOut[j];
			ArabicReverse(Out);

			Out = Out.replace((char) 0x200c, ' ');

			Out = Out.replace(szLamAndAlef, szLa);
			Out = Out.replace(szLamStickAndAlef, szLaStick);

			return Out;
		} catch (Exception ex) {
			return "";
		}
	}

	private static Typeface typeface;

	public static final Typeface GetFarsiFont(Context act) {
		if (typeface == null) {
			typeface = Typeface.createFromAsset(act.getAssets(), "Nazanin.ttf");
		}
		return typeface;
	}
}