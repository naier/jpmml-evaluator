/*
 * Copyright (c) 2013 Villu Ruusmann
 *
 * This file is part of JPMML-Evaluator
 *
 * JPMML-Evaluator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Evaluator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Evaluator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.evaluator;

import org.dmg.pmml.DataType;
import org.dmg.pmml.OpType;

public class ContinuousValue extends FieldValue {

	public ContinuousValue(DataType dataType, Object value){
		super(dataType, value);
	}

	@Override
	public OpType getOpType(){
		return OpType.CONTINUOUS;
	}

	@Override
	public int compareToString(String string){

		try {
			return super.compareToString(string);
		} catch(NumberFormatException nfeDefault){

			// Comparing an integer value with a floating-point reference value
			try {
				return TypeUtil.compare(DataType.DOUBLE, getValue(), TypeUtil.parse(DataType.DOUBLE, string));
			} catch(NumberFormatException nfeDouble){
				throw nfeDefault;
			}
		}
	}

	@Override
	public int compareToValue(FieldValue value){
		return super.compareToValue(value);
	}
}