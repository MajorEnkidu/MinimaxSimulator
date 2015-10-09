package de.uni_hannover.sra.minimax_simulator.io.importer.json;

import de.uni_hannover.sra.minimax_simulator.io.ProjectImportException;

/**
 * This provides some basic methods used by the JSON importers.
 *
 * @author Martin L&uuml;ck
 */
class Importer {

	/**
	 * Creates an enum.
	 *
	 * @param enumClass
	 *            the class of the enum to create
	 * @param element
	 *            the value of the enum
	 * @param <T>
	 *            the type of the enum
	 * @return
	 *            an enum of the given class with the given value
	 * @throws ProjectImportException
	 *            thrown if the enum can not be created
	 */
	static <T extends Enum<T>> T get(Class<T> enumClass, String element) throws ProjectImportException {
		String value = element;
		if (value == null) {
			throw new ProjectImportException("Content " + element + " is null");
		}

		try
		{
			return Enum.valueOf(enumClass, value);
		}
		catch (IllegalArgumentException e)
		{
			throw new ProjectImportException("Content " + element
					+ " is not a valid member of enum " + enumClass.getSimpleName() + ": "
					+ value, e);
		}
	}

}